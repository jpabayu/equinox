package org.equinox.api.context;

import org.apache.commons.lang.StringUtils;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class ContextBuilder implements Callable  {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message = eventContext.getMessage();
		
		Context context = new Context();
		
		String httpUserAgent = (String)message.getInboundProperty("User-Agent");
		if(!StringUtils.isBlank(httpUserAgent)) {
			context.setUserAgent(httpUserAgent);
		} else {
			context.setUserAgent("no-agent");
		}
		
		String httpCorrelationID = (String)message.getInboundProperty("Correlation-ID");
		if(!StringUtils.isBlank(httpCorrelationID)) {
			context.setCorrelationID(httpCorrelationID);
		} else {
			context.setCorrelationID(message.getUniqueId());
		}
		
		String httpMethod = (String)message.getInboundProperty("http.method");
		if(!StringUtils.isBlank(httpMethod)) {
			context.setHttpMethod(httpMethod);
		} else {
			context.setHttpMethod("");
		}
		
		String trxType = (String)message.getInboundProperty("http.request.uri");
		context.setTransactionType(trxType);
		
		return context;
	}
	
}
