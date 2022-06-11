package org.equinox.api.data;

import java.io.Serializable;

public class Currency implements Serializable {
	
	private static final long serialVersionUID = 8892806955692419082L;
	private String code;
	private String codeNumber;
	private boolean supported;
	
	public Currency(String code, String codeNumber, boolean supported) {
		this.code = code;
		this.codeNumber = codeNumber;
		this.supported = supported;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCodeNumber() {
		return codeNumber;
	}
	
	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}

	public boolean isSupported() {
		return supported;
	}

	public void setSupported(boolean supported) {
		this.supported = supported;
	}

	public static Currency getCurrency(String codeNumber) {
		switch(codeNumber) {
			case "008" :
				return new Currency("ALL", "008", false);
			case "012" :
				return new Currency("DZD", "012", false);
			case "032" :
				return new Currency("ARS", "032", false);
			case "036" :
				return new Currency("AUD", "036", false);
			case "044" :
				return new Currency("BSD", "044", false);
			case "048" :
				return new Currency("BHD", "048", false);
			case "050" :
				return new Currency("BDT", "050", false);
			case "051" :
				return new Currency("AMD", "051", false);
			case "052" :
				return new Currency("BBD", "052", false);
			case "060" :
				return new Currency("BMD", "060", false);
			case "064" :
				return new Currency("BTN", "064", false);
			case "068" :
				return new Currency("BOB", "068", false);
			case "072" :
				return new Currency("BWP", "072", false);
			case "084" :
				return new Currency("BZD", "084", false);
			case "090" :
				return new Currency("SBD", "090", false);
			case "096" :
				return new Currency("BND", "096", false);
			case "104" :
				return new Currency("MMK", "104", false);
			case "108" :
				return new Currency("BIF", "108", false);
			case "116" :
				return new Currency("KHR", "116", false);
			case "124" :
				return new Currency("CAD", "124", false);
			case "132" :
				return new Currency("CVE", "132", false);
			case "136" :
				return new Currency("KYD", "136", false);
			case "144" :
				return new Currency("LKR", "144", false);
			case "152" :
				return new Currency("CLP", "152", false);
			case "156" :
				return new Currency("CNY", "156", false);
			case "170" :
				return new Currency("COP", "170", false);
			case "174" :
				return new Currency("KMF", "174", false);
			case "188" :
				return new Currency("CRC", "188", false);
			case "191" :
				return new Currency("HRK", "191", false);
			case "192" :
				return new Currency("CUP", "192", false);
			case "203" :
				return new Currency("CZK", "203", false);
			case "208" :
				return new Currency("DKK", "208", false);
			case "214" :
				return new Currency("DOP", "214", false);
			case "222" :
				return new Currency("SVC", "222", false);
			case "230" :
				return new Currency("ETB", "230", false);
			case "232" :
				return new Currency("ERN", "232", false);
			case "238" :
				return new Currency("FKP", "238", false);
			case "242" :
				return new Currency("FJD", "242", false);
			case "262" :
				return new Currency("DJF", "262", false);
			case "270" :
				return new Currency("GMD", "270", false);
			case "292" :
				return new Currency("GIP", "292", false);
			case "320" :
				return new Currency("GTQ", "320", false);
			case "324" :
				return new Currency("GNF", "324", false);
			case "328" :
				return new Currency("GYD", "328", false);
			case "332" :
				return new Currency("HTG", "332", false);
			case "340" :
				return new Currency("HNL", "340", false);
			case "344" :
				return new Currency("HKD", "344", false);
			case "348" :
				return new Currency("HUF", "348", false);
			case "352" :
				return new Currency("ISK", "352", false);
			case "356" :
				return new Currency("INR", "356", false);
			case "360" :
				return new Currency("IDR", "360", true);
			case "364" :
				return new Currency("IRR", "364", false);
			case "368" :
				return new Currency("IQD", "368", false);
			case "376" :
				return new Currency("ILS", "376", false);
			case "388" :
				return new Currency("JMD", "388", false);
			case "392" :
				return new Currency("JPY", "392", false);
			case "398" :
				return new Currency("KZT", "398", false);
			case "400" :
				return new Currency("JOD", "400", false);
			case "404" :
				return new Currency("KES", "404", false);
			case "408" :
				return new Currency("KPW", "408", false);
			case "410" :
				return new Currency("KRW", "410", false);
			case "414" :
				return new Currency("KWD", "414", false);
			case "417" :
				return new Currency("KGS", "417", false);
			case "418" :
				return new Currency("LAK", "418", false);
			case "422" :
				return new Currency("LBP", "422", false);
			case "426" :
				return new Currency("LSL", "426", false);
			case "430" :
				return new Currency("LRD", "430", false);
			case "434" :
				return new Currency("LYD", "434", false);
			case "446" :
				return new Currency("MOP", "446", false);
			case "454" :
				return new Currency("MWK", "454", false);
			case "458" :
				return new Currency("MYR", "458", false);
			case "462" :
				return new Currency("MVR", "462", false);
			case "480" :
				return new Currency("MUR", "480", false);
			case "484" :
				return new Currency("MXN", "484", false);
			case "496" :
				return new Currency("MNT", "496", false);
			case "498" :
				return new Currency("MDL", "498", false);
			case "504" :
				return new Currency("MAD", "504", false);
			case "512" :
				return new Currency("OMR", "512", false);
			case "516" :
				return new Currency("NAD", "516", false);
			case "524" :
				return new Currency("NPR", "524", false);
			case "532" :
				return new Currency("ANG", "532", false);
			case "533" :
				return new Currency("AWG", "533", false);
			case "548" :
				return new Currency("VUV", "548", false);
			case "554" :
				return new Currency("NZD", "554", false);
			case "558" :
				return new Currency("NIO", "558", false);
			case "566" :
				return new Currency("NGN", "566", false);
			case "578" :
				return new Currency("NOK", "578", false);
			case "586" :
				return new Currency("PKR", "586", false);
			case "590" :
				return new Currency("PAB", "590", false);
			case "598" :
				return new Currency("PGK", "598", false);
			case "600" :
				return new Currency("PYG", "600", false);
			case "604" :
				return new Currency("PEN", "604", false);
			case "608" :
				return new Currency("PHP", "608", false);
			case "634" :
				return new Currency("QAR", "634", false);
			case "643" :
				return new Currency("RUB", "643", false);
			case "646" :
				return new Currency("RWF", "646", false);
			case "654" :
				return new Currency("SHP", "654", false);
			case "682" :
				return new Currency("SAR", "682", false);
			case "690" :
				return new Currency("SCR", "690", false);
			case "694" :
				return new Currency("SLL", "694", false);
			case "702" :
				return new Currency("SGD", "702", false);
			case "704" :
				return new Currency("VND", "704", false);
			case "706" :
				return new Currency("SOS", "706", false);
			case "710" :
				return new Currency("ZAR", "710", false);
			case "728" :
				return new Currency("SSP", "728", false);
			case "748" :
				return new Currency("SZL", "748", false);
			case "752" :
				return new Currency("SEK", "752", false);
			case "756" :
				return new Currency("CHF", "756", false);
			case "760" :
				return new Currency("SYP", "760", false);
			case "764" :
				return new Currency("THB", "764", false);
			case "776" :
				return new Currency("TOP", "776", false);
			case "780" :
				return new Currency("TTD", "780", false);
			case "784" :
				return new Currency("AED", "784", false);
			case "788" :
				return new Currency("TND", "788", false);
			case "800" :
				return new Currency("UGX", "800", false);
			case "807" :
				return new Currency("MKD", "807", false);
			case "818" :
				return new Currency("EGP", "818", false);
			case "826" :
				return new Currency("GBP", "826", false);
			case "834" :
				return new Currency("TZS", "834", false);
			case "840" :
				return new Currency("USD", "840", false);
			case "858" :
				return new Currency("UYU", "858", false);
			case "860" :
				return new Currency("UZS", "860", false);
			case "882" :
				return new Currency("WST", "882", false);
			case "886" :
				return new Currency("YER", "886", false);
			case "901" :
				return new Currency("TWD", "901", false);
			case "929" :
				return new Currency("MRU", "929", false);
			case "930" :
				return new Currency("STN", "930", false);
			case "931" :
				return new Currency("CUC", "931", false);
			case "932" :
				return new Currency("ZWL", "932", false);
			case "933" :
				return new Currency("BYN", "933", false);
			case "934" :
				return new Currency("TMT", "934", false);
			case "936" :
				return new Currency("GHS", "936", false);
			case "937" :
				return new Currency("VEF", "937", false);
			case "938" :
				return new Currency("SDG", "938", false);
			case "940" :
				return new Currency("UYI", "940", false);
			case "941" :
				return new Currency("RSD", "941", false);
			case "943" :
				return new Currency("MZN", "943", false);
			case "944" :
				return new Currency("AZN", "944", false);
			case "946" :
				return new Currency("RON", "946", false);
			case "947" :
				return new Currency("CHE", "947", false);
			case "948" :
				return new Currency("CHW", "948", false);
			case "949" :
				return new Currency("TRY", "949", false);
			case "950" :
				return new Currency("XAF", "950", false);
			case "951" :
				return new Currency("XCD", "951", false);
			case "952" :
				return new Currency("XOF", "952", false);
			case "953" :
				return new Currency("XPF", "953", false);
			case "960" :
				return new Currency("XDR", "960", false);
			case "965" :
				return new Currency("XUA", "965", false);
			case "967" :
				return new Currency("ZMW", "967", false);
			case "968" :
				return new Currency("SRD", "968", false);
			case "969" :
				return new Currency("MGA", "969", false);
			case "970" :
				return new Currency("COU", "970", false);
			case "971" :
				return new Currency("AFN", "971", false);
			case "972" :
				return new Currency("TJS", "972", false);
			case "973" :
				return new Currency("AOA", "973", false);
			case "975" :
				return new Currency("BGN", "975", false);
			case "976" :
				return new Currency("CDF", "976", false);
			case "977" :
				return new Currency("BAM", "977", false);
			case "978" :
				return new Currency("EUR", "978", false);
			case "979" :
				return new Currency("MXV", "979", false);
			case "980" :
				return new Currency("UAH", "980", false);
			case "981" :
				return new Currency("GEL", "981", false);
			case "984" :
				return new Currency("BOV", "984", false);
			case "985" :
				return new Currency("PLN", "985", false);
			case "986" :
				return new Currency("BRL", "986", false);
			case "990" :
				return new Currency("CLF", "990", false);
			case "994" :
				return new Currency("XSU", "994", false);
			case "997" :
				return new Currency("USN", "997", false);
			default :
				return new Currency("IDR", "360", true);
		}
	}
	
	/*
	@Override
    public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(code);
        out.writeUTF(codeNumber);
        out.writeBoolean(supported);
    }
  
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    	this.code = in.readUTF();
        this.codeNumber = in.readUTF();
        this.supported = in.readBoolean();
    }
    */
}
