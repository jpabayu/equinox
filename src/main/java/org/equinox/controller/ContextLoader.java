package org.equinox.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component
@PropertySource("/WEB-INF/app.properties")
public class ContextLoader {

	@Value("${api.host.url}")
	private String hostURL;
	@Value("${qris.min.transaction.amount}")
	private BigDecimal qrisMinTransactionAmount;
	@Value("${qris.max.transaction.amount}")
	private Integer qrisMaxTransactionAmount;
	@Value("${qris.off.us.transfer.type.id}")
	private Integer qrisOffUsTransferTypeID;

	@Value("${multibiller.iso.tid}")
	private String multibillerISOTID;
	@Value("${multibiller.iso.acc.id}")
	private String multibillerISOAccID;
	@Value("${pln.iso.tid}")
	private String plnISOTID;
	@Value("${pln.iso.acc.id}")
	private String plnISOAccID;
	@Value("${nns.jpa}")
	private String nnsJPA;

	public String getHostURL() {
		return hostURL;
	}

	public void setHostURL(String hostURL) {
		this.hostURL = hostURL;
	}

	public BigDecimal getQrisMinTransactionAmount() {
		return qrisMinTransactionAmount;
	}

	public void setQrisMinTransactionAmount(BigDecimal qrisMinTransactionAmount) {
		this.qrisMinTransactionAmount = qrisMinTransactionAmount;
	}

	public Integer getQrisMaxTransactionAmount() {
		return qrisMaxTransactionAmount;
	}

	public void setQrisMaxTransactionAmount(Integer qrisMaxTransactionAmount) {
		this.qrisMaxTransactionAmount = qrisMaxTransactionAmount;
	}

	public Integer getQrisOffUsTransferTypeID() {
		return qrisOffUsTransferTypeID;
	}

	public void setQrisOffUsTransferTypeID(Integer qrisOffUsTransferTypeID) {
		this.qrisOffUsTransferTypeID = qrisOffUsTransferTypeID;
	}

	public String getMultibillerISOTID() {
		return multibillerISOTID;
	}

	public void setMultibillerISOTID(String multibillerISOTID) {
		this.multibillerISOTID = multibillerISOTID;
	}

	public String getPlnISOTID() {
		return plnISOTID;
	}

	public void setPlnISOTID(String plnISOTID) {
		this.plnISOTID = plnISOTID;
	}

	public String getMultibillerISOAccID() {
		return multibillerISOAccID;
	}

	public void setMultibillerISOAccID(String multibillerISOAccID) {
		this.multibillerISOAccID = multibillerISOAccID;
	}

	public String getPlnISOAccID() {
		return plnISOAccID;
	}

	public String getNnsJPA() {
		return nnsJPA;
	}

	public void setNnsJPA(String nnsJPA) {
		this.nnsJPA = nnsJPA;
	}

	public void setPlnISOAccID(String plnISOAccID) {
		this.plnISOAccID = plnISOAccID;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
