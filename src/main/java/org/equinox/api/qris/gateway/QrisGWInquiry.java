package org.equinox.api.qris.gateway;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.equinox.api.config.Configuration;
import org.equinox.api.config.Key;
import org.equinox.api.data.Currency;
import org.equinox.api.iso.ISOUtils;
import org.equinox.api.qris.DefaultCrcCalculator;
import org.equinox.api.qris.QRDecomposer;
import org.equinox.api.utils.CommonUtil;

public class QrisGWInquiry extends QrisGWBaseGenerator {
	
	private static final long serialVersionUID = 8782806955692419084L;
	
	private boolean validQR;
	private boolean validCRC;
	private boolean merchantExists;
	
	public QrisGWInquiry(String qrData, String fromMember) {
		super();
		
		this.fromMember = fromMember;
		percentageTip = false;
		validCRC = false;
		merchantExists = false;
		QRDecomposer decomposer = new QRDecomposer(qrData);
		decomposer.setCrc(new DefaultCrcCalculator());
		
		Map<String, String> qrMap;
		try {
			qrMap = decomposer.doDecompose();
			validQR = true;
		} catch(Exception e) {
			//e.printStackTrace();
			validQR = false;
			return;
		}
		
		String qrType = qrMap.get("01");
		switch(qrType) {
			case "12":
				staticQR = false;
				break;
			default:
				staticQR = true;
				break;
		}
		
		Random rand = new Random();
		authID = StringUtils.leftPad(Integer.toString(rand.nextInt(1000000)), 6, "0");
		stan = ISOUtils.getQRISStan();
		rrn = "";
		
		Configuration config = Configuration.getInstance();
		String nnsJPA = config.getString(Key.NNS_JPA);
		
		for(int i = 26; i < 46; i++) {
			String tag = Integer.toString(i);
			if(qrMap.containsKey(tag)) {
				QRDecomposer dc = new QRDecomposer(qrMap.get(tag));
				dc.setCrc(new DefaultCrcCalculator());
				Map<String, String> map = dc.doDecompose();
				
				String acqDomain = "00";
				if(map.containsKey("00")) {
					acqDomain = map.get("00").trim();
				}
				
				String mPAN = map.get("01").trim();
				String mID = map.get("02").trim();
				String mCriteria = map.get("03").trim();
				
				if(mPAN.substring(0, 8).equalsIgnoreCase(nnsJPA)) {
					acquirerDomain = acqDomain;
					merchantPAN = mPAN;
					merchantID = mID;
					merchantCriteria = mCriteria;
					break;
				} else if(merchantPAN == null) {
					acquirerDomain = acqDomain;
					merchantPAN = mPAN;
					merchantID = mID;
					merchantCriteria = mCriteria;
				} else if(acquirerDomain.equalsIgnoreCase("00") && !acqDomain.equalsIgnoreCase("00")) {
					acquirerDomain = acqDomain;
					merchantPAN = mPAN;
					merchantID = mID;
					merchantCriteria = mCriteria;
				}
			}
		}
		
		merchantExists = merchantPAN != null;
		if(!merchantExists) {
			merchantOnUs = false;
			transferTypeId = config.getInteger(Key.QRIS_OFF_US_TRANSFER_TYPE_ID);
			try {
				merchantID = decomposer.getTagValue(qrMap.get("51"), "02").trim();
				merchantCriteria = decomposer.getTagValue(qrMap.get("51"), "03").trim();
			} catch(Exception e) {}
		} else {
			merchantPAN = merchantPAN + CommonUtil.calculateCheckDigit(merchantPAN);
			if(merchantPAN.substring(0, 8).equalsIgnoreCase(nnsJPA)) {
				merchantOnUs = true;
				transferTypeId = config.getInteger(Key.QRIS_ON_US_TRANSFER_TYPE_ID);
			} else {
				merchantOnUs = false;
				transferTypeId = config.getInteger(Key.QRIS_OFF_US_TRANSFER_TYPE_ID);
			}
		}
		
		merchantType = qrMap.get("52");
		
		if(qrMap.containsKey("53")) {
			transactionCurrency = Currency.getCurrency(qrMap.get("53").trim());
		} else {
			transactionCurrency = Currency.getCurrency("360");
		}
		
		if(qrMap.containsKey("54")) {
			String amountStr = qrMap.get("54").trim();
			if(!StringUtils.isBlank(amountStr)) {
				if(amountStr.equalsIgnoreCase("null")) {
					this.amount = new BigDecimal("0.00");
				} else {
					try {
						this.amount = new BigDecimal(amountStr).setScale(2, RoundingMode.HALF_DOWN);
					} catch(Exception e) {
						validQR = false;
					}
				}
			} else {
				this.amount = new BigDecimal("0.00");
			}
		} else {
			this.amount = new BigDecimal("0.00");
		}
		
		if(qrMap.containsKey("55")) {
			String tipIndicator = qrMap.get("55").trim();
			switch(tipIndicator) {
				case "01":
					this.convenienceFee = new BigDecimal("0.00");
					break;
				case "02":
					if(qrMap.containsKey("56")) {
						this.convenienceFee = new BigDecimal(qrMap.get("56").trim()).setScale(2, RoundingMode.HALF_DOWN);
					} else {
						this.convenienceFee = null;
					}
					break;
				case "03":
					percentageTip = true;
					if(qrMap.containsKey("56")) {
				        this.convenienceFee = new BigDecimal(qrMap.get("56").trim());
					} else if(qrMap.containsKey("57")) {
						this.convenienceFee = new BigDecimal(qrMap.get("57").trim());
					} else {
						this.convenienceFee = new BigDecimal("0.00");
					}
					break;
				default:
					this.convenienceFee = null;
					break;
			}
		} else {
			this.convenienceFee = null;
		}
		
		countryCode = qrMap.get("58").trim();
		merchantName = qrMap.get("59").trim();
		merchantCity = qrMap.get("60").trim();
		postalCode = qrMap.get("61").trim();
		
		if(qrMap.containsKey("62")) {
			additionalData = qrMap.get("62");
			
			QRDecomposer tag62Decomposer = new QRDecomposer(additionalData);
			tag62Decomposer.setCrc(new DefaultCrcCalculator());
			
			Map<String, String> tag62Map;
			try {
				tag62Map = tag62Decomposer.doDecompose();
				if(tag62Map.containsKey("03")) {
					felloTerminalId = tag62Map.get("03");
				}
				
				if(tag62Map.containsKey("07")) {
					acceptorTID = tag62Map.get("07");
					if(acceptorTID.length() > 16) {
						int start = acceptorTID.length()-16;
						acceptorTID = acceptorTID.substring(start);
					}
				}
				
			} catch(Exception e) {
				acceptorTID = merchantID;
			}
		} else {
			additionalData = "";
			acceptorTID = merchantID;
		}
		
		if(qrMap.containsKey("63")) {
			validCRC = decomposer.isValidCRC(qrMap.get("63"));
		}
		
	}
	
	@Override
	public HashMap<String, String> generateRequest() throws Exception {
		//create request for inquiry mpan
		Configuration config = Configuration.getInstance();
		HashMap<String, String> result = new HashMap<String, String>();
		
		result.put("authID", authID);
		
		String nnsJPA = config.getString(Key.NNS_JPA);
		StringBuilder sb = new StringBuilder();
		sb.append(nnsJPA);
		sb.append("8112284544");
		int checkDigit = CommonUtil.calculateCheckDigit(sb.toString());
		sb.append(checkDigit);
		result.put("customerPAN", sb.toString());
		
		result.put("multipleMPAN", "true");
		result.put("amount", amount.toPlainString());
		//result.put("amount", "1000");
		
		BigDecimal zero = new BigDecimal("0");
		if(convenienceFee == null) {
			result.put("convenienceFee", "-1");
		} else if(convenienceFee.compareTo(zero) >= 0) {
			if(percentageTip) {
				BigDecimal tipValue = amount.multiply(convenienceFee)
						.divide(new BigDecimal(100))
						.setScale(2, RoundingMode.HALF_DOWN);
				
				result.put("convenienceFee", amount.add(tipValue)
						.setScale(2, RoundingMode.HALF_DOWN).toPlainString());
			} else {
				result.put("convenienceFee", convenienceFee.toPlainString());
			}
				
		} else {
			result.put("convenienceFee", "0.00");
		}
		
		result.put("nationalMID", merchantID);
		
		if(merchantCriteria == null) {
			result.put("merchantCriteria", "URE");
		} else {
			result.put("merchantCriteria", merchantCriteria);
		}
		
		result.put("merchantType", merchantType);
		result.put("transactionCurrency", transactionCurrency.getCodeNumber());
		result.put("countryCode", countryCode);
		result.put("merchantName", merchantName);
		result.put("merchantCity", merchantCity);
		result.put("postalCode", postalCode);
		result.put("acceptorTID", acceptorTID);
		
		return result;
	}
	
	//QR String from tag 26 to 45
	public void initMerchant(String merchantData) {
		merchantExists = false;
		QRDecomposer rootDC = new QRDecomposer(merchantData);
		rootDC.setCrc(new DefaultCrcCalculator());
		Map<String, String> merchantMap;
		
		if(merchantData != null && !merchantData.isEmpty()) {
			try {
				merchantMap = rootDC.doDecompose();
				merchantExists = true;
			} catch(Exception e) {
				e.printStackTrace();
				return;
			}
		} else {
			return;
		}
		
		merchantPAN = null;
		for(int i = 26; i < 46; i++) {
			String tag = Integer.toString(i);
			if(merchantMap.containsKey(tag)) {
				QRDecomposer dc = new QRDecomposer(merchantMap.get(tag));
				dc.setCrc(new DefaultCrcCalculator());
				Map<String, String> map = dc.doDecompose();
				
				String acqDomain = "00";
				if(map.containsKey("00")) {
					acqDomain = map.get("00").trim();
				}
				
				String mPAN = map.get("01").trim();
				String mID = map.get("02").trim();
				String mCriteria = map.get("03").trim();
				
				if(merchantPAN == null) {
					acquirerDomain = acqDomain;
					merchantPAN = mPAN;
					merchantID = mID;
					merchantCriteria = mCriteria;
					
					if(!acquirerDomain.equalsIgnoreCase("00")) {
						break;
					}
				} else if(!acqDomain.equalsIgnoreCase("00")) {
					acquirerDomain = acqDomain;
					merchantPAN = mPAN;
					merchantID = mID;
					merchantCriteria = mCriteria;
					
					break;
				}
			}
		}
		
		if(merchantPAN != null) {
			merchantPAN = merchantPAN + CommonUtil.calculateCheckDigit(merchantPAN);
		}
		
		if(acceptorTID == null) {
			acceptorTID = merchantID;
		}
	}
	
	public String generateRrn(StringBuilder sb, String data) {
		String hash = DigestUtils.sha256Hex(data).toUpperCase();
		sb.setLength(0);
		sb.append(hash.substring(0, 6));
		sb.append(hash.substring(hash.length()-6));
		rrn = sb.toString();
		
		return rrn;
	}

	public boolean isValidQR() {
		return validQR;
	}

	public void setValidQR(boolean validQR) {
		this.validQR = validQR;
	}

	public boolean isValidCRC() {
		return validCRC;
	}

	public void setValidCRC(boolean validCRC) {
		this.validCRC = validCRC;
	}

	public boolean isMerchantExists() {
		return merchantExists;
	}

	public void setMerchantExists(boolean merchantExists) {
		this.merchantExists = merchantExists;
	}
}
