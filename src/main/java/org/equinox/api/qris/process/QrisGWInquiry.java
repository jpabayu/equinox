package org.equinox.api.qris.process;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.equinox.api.qrcode.DefaultCrcCalculator;
import org.equinox.api.qrcode.QRDecomposer;
import org.equinox.api.qris.CommonUtils;
import org.equinox.api.qris.Currency;
import org.equinox.api.qris.iso.ISOUtils;
import org.equinox.controller.ContextLoader;
import org.springframework.beans.factory.annotation.Autowired;

public class QrisGWInquiry extends QrisGWBaseGenerator {
	
	private static final long serialVersionUID = -4882761871211650600L;
	private String acquirerDomain;
	private String merchantPAN;
	private String merchantID;
	private String merchantName;
	private String merchantCity;
	private String merchantCriteria;
	private String merchantType;
	private String countryCode;
	private String postalCode;
	private String additionalData;
	private String acceptorTID;
	private Currency transactionCurrency;
	private String authID;
	private String stan;
	private String rrn;
	private boolean validQR;
	private boolean validCRC;
	private boolean merchantExists;
	
	@Autowired
	private ContextLoader contextLoader;
	
	public QrisGWInquiry(String qrData) {
		super();
		
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
		
		Random rand = new Random();
		authID = StringUtils.leftPad(Integer.toString(rand.nextInt(1000000)), 6, "0");
		stan = ISOUtils.getQRISStan();
		rrn = "";
		
		String nnsJPA = contextLoader.getNnsJPA();
		
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
			transferTypeId = contextLoader.getQrisOffUsTransferTypeID();
			try {
				merchantID = decomposer.getTagValue(qrMap.get("51"), "02").trim();
				merchantCriteria = decomposer.getTagValue(qrMap.get("51"), "03").trim();
			} catch(Exception e) {}
		} else {
			merchantPAN = merchantPAN + CommonUtils.calculateCheckDigit(merchantPAN);
			if(merchantPAN.substring(0, 8).equalsIgnoreCase(nnsJPA)) {
				merchantOnUs = true;
				transferTypeId = 0;
			} else {
				merchantOnUs = false;
				transferTypeId =contextLoader.getQrisOffUsTransferTypeID();
			}
		}
		
		merchantType = qrMap.get("52");
		
		if(qrMap.containsKey("53")) {
			transactionCurrency = Currency.getCurrency(qrMap.get("53").trim());
		} else {
			transactionCurrency = Currency.getCurrency("360");
		}
		
		if(qrMap.containsKey("54")) {
			this.amount = new BigDecimal(qrMap.get("54").trim()).setScale(2, RoundingMode.HALF_DOWN);
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
			try {
				acceptorTID = decomposer.getTagValue(additionalData, "07").trim();
				if(acceptorTID.length() > 16) {
					int start = acceptorTID.length()-16;
					acceptorTID = acceptorTID.substring(start);
				}
			} catch(Exception e) {
				acceptorTID = merchantID;
			}
		} else {
			additionalData = null;
			acceptorTID = merchantID;
		}
		
		if(qrMap.containsKey("63")) {
			validCRC = decomposer.isValidCRC(qrMap.get("63"));
		}
		
	}
	
	@Override
	public HashMap<String, String> generateRequest() throws Exception {
		//create request for inquiry mpan
		HashMap<String, String> result = new HashMap<String, String>();
		
		result.put("authID", authID);
		
		String nnsJPA = contextLoader.getNnsJPA();
		StringBuilder sb = new StringBuilder();
		sb.append(nnsJPA);
		sb.append("8112284544");
		int checkDigit = CommonUtils.calculateCheckDigit(sb.toString());
		sb.append(checkDigit);
		result.put("customerPAN", sb.toString());
		
		result.put("multipleMPAN", "true");
		result.put("amount", amount.toPlainString());
		
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
			merchantPAN = merchantPAN + CommonUtils.calculateCheckDigit(merchantPAN);
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
	
	public String getAcquirerDomain() {
		return acquirerDomain;
	}

	public void setAcquirerDomain(String acquirerDomain) {
		this.acquirerDomain = acquirerDomain;
	}

	public String getMerchantPAN() {
		return merchantPAN;
	}

	public void setMerchantPAN(String merchantPAN) {
		this.merchantPAN = merchantPAN;
	}

	public String getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantCity() {
		return merchantCity;
	}

	public void setMerchantCity(String merchantCity) {
		this.merchantCity = merchantCity;
	}

	public String getMerchantCriteria() {
		return merchantCriteria;
	}

	public void setMerchantCriteria(String merchantCriteria) {
		this.merchantCriteria = merchantCriteria;
	}
	
	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}

	public String getAcceptorTID() {
		return acceptorTID;
	}

	public void setAcceptorTID(String acceptorTID) {
		this.acceptorTID = acceptorTID;
	}

	public Currency getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(Currency transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}
	
	public String getAuthID() {
		return authID;
	}

	public void setAuthID(String authID) {
		this.authID = authID;
	}

	public String getStan() {
		return stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}
	
	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
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
