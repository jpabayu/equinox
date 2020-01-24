package org.equinox.api.process;

import java.util.TreeMap;

import org.equinox.api.qrcode.DefaultCrcCalculator;
import org.equinox.api.qrcode.QRDecomposer;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class QRProcessor implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		TreeMap<String, String> map = eventContext.getMessage().getInvocationProperty("originalPayload");
		String qrdata = map.get("data");
		QRDecomposer qd = new QRDecomposer(qrdata);
		qd.setCrc(new DefaultCrcCalculator());
		return qd;
	}

}
