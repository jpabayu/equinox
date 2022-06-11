package org.equinox.api.bellatrix;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.equinox.api.bellatrix.account.LoadBalanceInquiryResponse;
import org.equinox.api.bellatrix.account.LoadTransactionHistoryResponse;
import org.equinox.api.bellatrix.interbank.BankAccountTransferInquiryResponse;
import org.equinox.api.bellatrix.interbank.BankAccountTransferPaymentResponse;
import org.equinox.api.bellatrix.interbank.LoadAccountTransferResponse;
import org.equinox.api.bellatrix.interbank.LoadBankTransferResponse;
import org.equinox.api.bellatrix.interbank.LoadScheduleTransferByUsernameResponse;
import org.equinox.api.bellatrix.member.LoadMemberByUsernameResponse;
import org.equinox.api.bellatrix.message.LoadMessagesByUsernameResponse;
import org.equinox.api.bellatrix.payment.DoInquiryResponse;
import org.equinox.api.bellatrix.payment.DoPaymentResponse;
import org.equinox.api.bellatrix.payment.TransactionStatusResponse;
import org.equinox.api.bellatrix.pos.LoadTerminalByIdResponse;
import org.equinox.api.bellatrix.pos.LoadTerminalByNNSIDResponse;
import org.equinox.api.bellatrix.virtualaccount.InquiryVAResponse;
import org.equinox.api.bellatrix.virtualaccount.PaymentVAResponse;

public class BellatrixJAXBContext {
	
	private static final Object lock = new Object();
	private static volatile BellatrixJAXBContext bltrxContext;
	private JAXBContext jaxbContext;
	
	private BellatrixJAXBContext() {
		try {
			@SuppressWarnings("rawtypes")
			Class[] classes = new Class[] {
					BankAccountTransferInquiryResponse.class,
					BankAccountTransferPaymentResponse.class,
					DoInquiryResponse.class,
					DoPaymentResponse.class,
					InquiryVAResponse.class,
					LoadAccountTransferResponse.class,
					LoadBalanceInquiryResponse.class,
					LoadBankTransferResponse.class,
                    LoadMemberByUsernameResponse.class,
                    LoadMessagesByUsernameResponse.class,
                    LoadScheduleTransferByUsernameResponse.class,
                    LoadTerminalByIdResponse.class,
                    LoadTerminalByNNSIDResponse.class,
                    LoadTransactionHistoryResponse.class,
                    PaymentVAResponse.class,
                    TransactionStatusResponse.class
                };
			jaxbContext = JAXBContext.newInstance(classes);
        } catch (JAXBException ignored) {
        	ignored.printStackTrace();
        }
	}
	
	public static BellatrixJAXBContext getInstance() { 
		BellatrixJAXBContext context = bltrxContext;
    	if (context == null) {
	        synchronized (lock) { 
	        	context = bltrxContext;
	            if (context == null) {  
	            	context = new BellatrixJAXBContext();
	            	bltrxContext = context;
	            }
	        }
	    }
		
        return bltrxContext;
    }

	public <T> T parseString(String xmlString, String targetElement, Class<T> targetClass) throws Exception {
		XMLInputFactory xmlInputFactory = null;
		XMLStreamReader reader = null;
		T result = null;
		
		try {
			xmlInputFactory = XMLInputFactory.newInstance();
	        reader = xmlInputFactory.createXMLStreamReader(new StringReader(xmlString));
	        
	        while (reader.hasNext()) {
	            int type = reader.next();
	            if (type == XMLStreamReader.START_ELEMENT && reader.getLocalName().equals(targetElement)) {
	                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	                JAXBElement<T> jb = unmarshaller.unmarshal(reader, targetClass);
	                result = jb.getValue();
	                break;
	            }
	        }
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch(Exception ex) {}
			}
		}
        
        return result;
	}
}
