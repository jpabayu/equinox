package org.equinox.api.config;

public enum Key {
	
	ACCESS_TYPE_ID_PIN("access.type.id.pin"),
	ACCESS_TYPE_ID_SECRET_AUTH("access.type.id.secret.auth"),
	ACCESS_TYPE_ID_API_KEY("access.type.id.api.key"),
	ACCESS_TYPE_ID_SYS_CREDENTIAL("access.type.id.sys.credential"),
	
	APP_BASE_URL("app.base.url"),
	APP_BASE_URL_CREDENTIAL("app.base.url.credential"),

	API_TYK_HOST("api.tyk.host"),
	API_TYK_PORT("api.tyk.port"),
	API_CORE_WS_HOST("api.core.ws.host"),
	API_JMS_BROKER_URL("api.jms.broker.url"),
	API_MEMBER_KYC_FILE_PATH("api.member.kyc.file.path"),
	API_JWT_ISSUER_VALUE("api.jwt.issuer.value"),
	API_JWT_SUBJECT_VALUE("api.jwt.subject.value"),
	API_WS_HEADER_TOKEN("api.ws.header.token"),
	API_WS_HEADER_TOKEN_NC("api.ws.header.token.nc"),
	API_WS_HEADER_TOKEN_QRIS("api.ws.header.token.qris"),
	
	HOST_SANDBOX_URL("host.sandbox.url"),
	HOST_DASHBOARD_URL("host.dashboard.url"),
	
	VERIFY_EMAIL_URL("verify.email.url"),
	API_HOST_URL("api.host.url"),

	//Payment Channel
	DOKU_CHANNEL_ID("doku.channel.id"),
	DOKU_TRANSFER_TYPE_ID("doku.transfer.type.id"),
	
	VA_CHANNEL_ID("va.channel.id"),
	VA_TRANSFER_TYPE_ID("va.transfer.type.id"),

	RETAIL_CHANNEL_ID("retail.channel.id"),
	IDM_TRANSFER_TYPE_ID("idm.transfer.type.id"),
	
	LINK_AJA_CHANNEL_ID("link.aja.channel.id"),
	LINK_AJA_TRANSFER_TYPE_ID("link.aja.transfer.type.id"),

	PREREGISTERED_GROUP_ID("preregistered.group.id"),
	UNREGISTERED_GROUP_ID("unregistered.group.id"),

	//PPOB
	MULTIBILLER_ISO_ACC_ID("multibiller.iso.acc.id"),
	MULTIBILLER_ISO_TID("multibiller.iso.tid"),
	
	PLN_ISO_ACC_ID("pln.iso.acc.id"),
	PLN_ISO_TID("pln.iso.tid"),
	
	//QRIS
	NNS_JPA("nns.jpa"),
	JALIN_USERNAME("jalin.usernam"),
	
	QRIS_GW_IP("qris.gw.ip"),
	QRIS_GW_PORT("qris.gw.port"),

	QRIS_OFF_US_TRANSFER_TYPE_ID("qris.off.us.transfer.type.id"),	
	QRIS_ON_US_TRANSFER_TYPE_ID("qris.on.us.transfer.type.id"),

	QRIS_CACHE_TTL_CREDIT("qris.cache.ttl.credit"),
	QRIS_CACHE_TTL_INQUIRY("qris.cache.ttl.inquiry"),
	QRIS_CACHE_TTL_INVOICE("qris.cache.ttl.invoice");
	
	private String key;

    Key(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }

    public String toString() {
        return key();
    }
}
