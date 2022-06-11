package org.equinox.api.qris.gateway;

import java.util.HashMap;

import org.equinox.api.data.ResponseStatus;
import org.equinox.api.data.Status;
import org.equinox.api.data.StatusBuilder;
import org.equinox.api.iso.ResponseCode;
import org.equinox.api.iso.ResponseCodeStatus;

public class QrisGWStatusMapper {
	
	private static final Object lock = new Object();
	
	// static variable single_instance of type Singleton 
    private static volatile QrisGWStatusMapper qrisGWStatusMapper = null;
    
    private HashMap<String, ResponseCode> rcMap = null;
  
    // private constructor restricted to this class itself 
    private QrisGWStatusMapper() 
    { 
        rcMap = new HashMap<String, ResponseCode>();
        
        String rc = "00"; 
        rcMap.put(rc, new ResponseCode(rc, "Sukses", ResponseCodeStatus.SUCCESS));
        
        rc = "01";
        rcMap.put(rc, new ResponseCode(rc, "Invalid username or password", ResponseCodeStatus.FAILED));
        
        rc = "02";
        rcMap.put(rc, new ResponseCode(rc, "Invalid checksum", ResponseCodeStatus.FAILED));
        
        rc = "03";
        rcMap.put(rc, new ResponseCode(rc, "Invalid Merchant", ResponseCodeStatus.FAILED));

        rc = "05";
        rcMap.put(rc, new ResponseCode(rc, "Do not Honor", ResponseCodeStatus.FAILED));
        
        rc = "06";
        rcMap.put(rc, new ResponseCode(rc, "Undefined Error", ResponseCodeStatus.FAILED));
        
        rc = "A0";
        rcMap.put(rc, new ResponseCode(rc, "Payment Cancelled", ResponseCodeStatus.FAILED));

        rc = "12";
        rcMap.put(rc, new ResponseCode(rc, "Invalid Transaction", ResponseCodeStatus.FAILED));

        rc = "13";
        rcMap.put(rc, new ResponseCode(rc, "Invalid Amount", ResponseCodeStatus.FAILED));
        
        rc = "14";
        rcMap.put(rc, new ResponseCode(rc, "Invalid PAN Number", ResponseCodeStatus.FAILED));

        rc = "30";
        rcMap.put(rc, new ResponseCode(rc, "Format Error", ResponseCodeStatus.FAILED));
        
        rc = "31";
        rcMap.put(rc, new ResponseCode(rc, "nnsid not registered", ResponseCodeStatus.FAILED));
        
        rc = "51";
        rcMap.put(rc, new ResponseCode(rc, "Insufficient Funds", ResponseCodeStatus.FAILED));
        
        rc = "57";
        rcMap.put(rc, new ResponseCode(rc, "Transaction Not Permitted to Cardholder / QR is expired", ResponseCodeStatus.FAILED));
        
        rc = "58";
        rcMap.put(rc, new ResponseCode(rc, "Transaction Not Permitted to Terminal", ResponseCodeStatus.FAILED));
        
        rc = "59";
        rcMap.put(rc, new ResponseCode(rc, "Suspected Fraud", ResponseCodeStatus.FAILED));
        
        rc = "61";
        rcMap.put(rc, new ResponseCode(rc, "Exceeds Transaction Limit", ResponseCodeStatus.FAILED));
        
        rc = "62";
        rcMap.put(rc, new ResponseCode(rc, "Restricted Card", ResponseCodeStatus.FAILED));

        rc = "65";
        rcMap.put(rc, new ResponseCode(rc, "Exceeds Transaction Frequency Limit", ResponseCodeStatus.FAILED));
        
        rc = "68";
        rcMap.put(rc, new ResponseCode(rc, "Suspend Transaction", ResponseCodeStatus.SUSPECT));

        rc = "70";
        rcMap.put(rc, new ResponseCode(rc, "error general system", ResponseCodeStatus.FAILED));
        
        rc = "71";
        rcMap.put(rc, new ResponseCode(rc, "tidak ada routing config", ResponseCodeStatus.FAILED));
        
        rc = "72";
        rcMap.put(rc, new ResponseCode(rc, "koneksi ditolak", ResponseCodeStatus.FAILED));
        
        rc = "73";
        rcMap.put(rc, new ResponseCode(rc, "Page not Found", ResponseCodeStatus.FAILED));
        
        rc = "74";
        rcMap.put(rc, new ResponseCode(rc, "error timeout", ResponseCodeStatus.FAILED));
        
        rc = "75";
        rcMap.put(rc, new ResponseCode(rc, "error parsing data", ResponseCodeStatus.FAILED));
        
        rc = "76";
        rcMap.put(rc, new ResponseCode(rc, "tidak ada client socket yg konek ke server socket", ResponseCodeStatus.FAILED));
        
        rc = "77";
        rcMap.put(rc, new ResponseCode(rc, "tidak ditemukan proses yg request iso / client iso sudah timeout / putus", ResponseCodeStatus.FAILED));
        
        rc = "78";
        rcMap.put(rc, new ResponseCode(rc, "error saat konversi iso ke json atau sebaliknya", ResponseCodeStatus.FAILED));
        
        rc = "79";
        rcMap.put(rc, new ResponseCode(rc, "processing code tidak ada / salah path rest", ResponseCodeStatus.FAILED));
        
        rc = "80";
        rcMap.put(rc, new ResponseCode(rc, "server socket tidak ada / mati / belum dinyalakan", ResponseCodeStatus.FAILED));
        
        rc = "81";
        rcMap.put(rc, new ResponseCode(rc, "Original transaction not found", ResponseCodeStatus.FAILED));
        
        rc = "82";
        rcMap.put(rc, new ResponseCode(rc, "Original transaction is failed", ResponseCodeStatus.FAILED));
        
        rc = "83";
        rcMap.put(rc, new ResponseCode(rc, "Original transaction already refunded", ResponseCodeStatus.FAILED));
        
        rc = "90";
        rcMap.put(rc, new ResponseCode(rc, "Cutoff in Progress", ResponseCodeStatus.FAILED));

        rc = "91";
        rcMap.put(rc, new ResponseCode(rc, "Link down", ResponseCodeStatus.FAILED));

        rc = "92";
        rcMap.put(rc, new ResponseCode(rc, "Invalid Routing", ResponseCodeStatus.FAILED));

        rc = "94";
        rcMap.put(rc, new ResponseCode(rc, "Duplicate Transmission", ResponseCodeStatus.FAILED));
        
        rc = "96";
        rcMap.put(rc, new ResponseCode(rc, "System Malfunction", ResponseCodeStatus.FAILED));
        
    } 
  
    // static method to create instance of Singleton class 
    private static QrisGWStatusMapper getInstance() {
    	QrisGWStatusMapper mapper = qrisGWStatusMapper;
    	if (mapper == null) {
	        synchronized (lock) {
	            mapper = qrisGWStatusMapper;
	            if (mapper == null) {  
	            	mapper = new QrisGWStatusMapper();
	            	qrisGWStatusMapper = mapper;
	            }
	        }
	    }
		
        return mapper; 
    }
	
    public static ResponseCode getResponseCode(String responseCode) {
    	QrisGWStatusMapper mapper = getInstance();
		
		if(responseCode == null) return mapper.rcMap.get("06");
		
		if(mapper.rcMap.containsKey(responseCode)) {
			return mapper.rcMap.get(responseCode);
		} else {
			return mapper.rcMap.get("06");
		}
    }
    
    public static ResponseStatus getResponseStatus(String responseCode) {
    	ResponseCode rc = getResponseCode(responseCode);
    	return getResponseStatus(rc);
    }
    
    public static ResponseStatus getResponseStatus(ResponseCode responseCode) {
		
		if(responseCode == null) return StatusBuilder.getStatus(Status.UNDEFINED_ERROR.name());
		
		switch(responseCode.getCode()) {
			case "00" :
				return StatusBuilder.getStatus(Status.PROCESSED.name());
			case "01" :
				return StatusBuilder.getStatus(Status.INVALID_PARAMETER.name());
			case "02" :
				return StatusBuilder.getStatus(Status.INVALID_PARAMETER.name());
			case "03" :
				return StatusBuilder.getStatus(Status.INVALID_MERCHANT.name());
			case "05" :
				return StatusBuilder.getStatus(Status.INVALID_TRANSACTION.name());
			case "06" :
				return StatusBuilder.getStatus(Status.UNDEFINED_ERROR.name());
			case "A0" :
				return StatusBuilder.getStatus(Status.PAYMENT_CANCELED.name());	
			case "12" :
				return StatusBuilder.getStatus(Status.INVALID_TRANSACTION.name());
			case "13" :
				return StatusBuilder.getStatus(Status.INVALID_AMOUNT.name());
			case "14" :
				return StatusBuilder.getStatus(Status.INVALID_PARAMETER.name());
			case "30" :
				return StatusBuilder.getStatus(Status.MESSAGE_FORMAT_ERROR.name());
			case "31" :
				return StatusBuilder.getStatus(Status.UNSUPPORTED_MERCHANT.name());
			case "51" :
				return StatusBuilder.getStatus(Status.INVALID_TRANSACTION.name());
			case "57" :
				return StatusBuilder.getStatus(Status.INVALID_QR.name());
			case "58" :
				return StatusBuilder.getStatus(Status.INVALID_TRANSACTION.name());
			case "59" :
				return StatusBuilder.getStatus(Status.INVALID_TRANSACTION.name());
			case "61" :
				return StatusBuilder.getStatus(Status.TRANSACTION_LIMIT_REACHED.name());
			case "62" :
				return StatusBuilder.getStatus(Status.INVALID_TRANSACTION.name());
			case "65" :
				return StatusBuilder.getStatus(Status.MONTHLY_CREDIT_LIMIT_REACHED.name());
			case "68" :
				return StatusBuilder.getStatus(Status.PENDING.name());
			case "70" :
				return StatusBuilder.getStatus(Status.ISO_SYSTEM_MALFUNCTION.name());
			case "71" :
				return StatusBuilder.getStatus(Status.ISO_UNABLE_ROUTE_TRANSACTION.name());
			case "72" :
				return StatusBuilder.getStatus(Status.HOST_CONNECTION_FAILED.name());	
			case "73" :
				return StatusBuilder.getStatus(Status.SERVICE_NOT_FOUND.name());
			case "74" :
				return StatusBuilder.getStatus(Status.INVALID_TRANSACTION.name());
			case "75" :
				return StatusBuilder.getStatus(Status.ISO_PACKET_DECOMPOSITION_FAILURE.name());
			case "76" :
				return StatusBuilder.getStatus(Status.HOST_CONNECTION_FAILED.name());
			case "77" :
				return StatusBuilder.getStatus(Status.HOST_CONNECTION_TIMEOUT.name());
			case "78" :
				return StatusBuilder.getStatus(Status.ISO_PACKET_DECOMPOSITION_FAILURE.name());
			case "79" :
				return StatusBuilder.getStatus(Status.INVALID_PARAMETER.name());
			case "80" :
				return StatusBuilder.getStatus(Status.HOST_CONNECTION_FAILED.name());
			case "81" :
				return StatusBuilder.getStatus(Status.PAYMENT_CODE_NOT_FOUND.name());
			case "82" :
				return StatusBuilder.getStatus(Status.PAYMENT_CANCELED.name());
			case "83" :
				return StatusBuilder.getStatus(Status.PAYMENT_CANCELED.name());
			case "90" :
				return StatusBuilder.getStatus(Status.ISO_CUT_OFF_IN_PROGRESS.name());
			case "91" :
				return StatusBuilder.getStatus(Status.ISO_SERVER_IS_DOWN.name());
			case "92" :
				return StatusBuilder.getStatus(Status.ISO_UNABLE_ROUTE_TRANSACTION.name());
			case "94" :
				return StatusBuilder.getStatus(Status.DUPLICATE_TRANSACTION.name());
			case "96" :
				return StatusBuilder.getStatus(Status.ISO_SYSTEM_MALFUNCTION.name());
			default :
				return StatusBuilder.getStatus(Status.UNDEFINED_ERROR.name());
		}
    }
	
}
