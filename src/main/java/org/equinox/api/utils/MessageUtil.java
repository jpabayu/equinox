package org.equinox.api.utils;

public final class MessageUtil {
	
	public static String getQRISMerchantReceipt(
			String acceptedLanguage, String mpan, String mid, 
			String merchantName, String transactionDate, 
			String transactionNumber, String traceNumber, String rrn, 
			String invoiceId, String amount
	) {
		StringBuilder sb = new StringBuilder();
		
		if(acceptedLanguage != null) {
			if(acceptedLanguage.equals("en-US")) {
				sb.append("Dear Fello Merchant,\n");
		        sb.append("PAN: ").append(mpan).append("\n");
		        sb.append("MID: ").append(mid).append("\n");
		        sb.append("Name: ").append(merchantName).append("\n\n");
		        
		        sb.append("You have received a QRIS payment with details as follow:\n");
		        sb.append("Transaction Date: ").append(transactionDate).append("\n");
		        sb.append("Transaction Number: ").append(transactionNumber).append("\n");
		        sb.append("Trace Number: ").append(traceNumber).append("\n");
		        sb.append("RRN: ").append(rrn).append("\n");
		        sb.append("Invoice ID: ").append(invoiceId).append("\n");
		        sb.append("Amount: ").append(amount).append("\n\n");
		        
		        sb.append("We hope this information will be useful to you.\n\n");
		        
		        sb.append("Best regards,\n");
		        sb.append("Fello Team");
				
		        return sb.toString();
			}
		}
		
		sb.append("Hai Merchant Fello,\n");
        sb.append("PAN: ").append(mpan).append("\n");
        sb.append("MID: ").append(mid).append("\n");
        sb.append("Nama: ").append(merchantName).append("\n\n");
        
        sb.append("Anda telah menerima pembayaran QRIS dengan detail sebagai berikut:\n");
        sb.append("Tanggal Transaksi: ").append(transactionDate).append("\n");
        sb.append("Nomor Transaksi: ").append(transactionNumber).append("\n");
        sb.append("Trace Number: ").append(traceNumber).append("\n");
        sb.append("RRN: ").append(rrn).append("\n");
        sb.append("Nomor Invoice: ").append(invoiceId).append("\n");
        sb.append("Jumlah: ").append(amount).append("\n\n");
        
        sb.append("Kami harap informasi ini bermanfaat bagi anda.\n\n");
        
        sb.append("Salam,\n");
        sb.append("Tim Fello");
		
		
		return sb.toString();
	}
	
}
