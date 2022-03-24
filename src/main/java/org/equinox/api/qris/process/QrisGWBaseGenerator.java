package org.equinox.api.qris.process;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

import org.equinox.controller.ContextLoader;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class QrisGWBaseGenerator implements Serializable {

	private static final long serialVersionUID = -1900820785787623287L;

	@Autowired
	private static ContextLoader contextLoader;

	private static BigDecimal MIN_TRANSACTION_AMOUNT = null;
	private static BigDecimal MAX_TRANSACTION_AMOUNT = null;

	protected boolean percentageTip;
	protected BigDecimal amount;
	protected BigDecimal convenienceFee;
	protected boolean merchantOnUs;
	protected int transferTypeId;

	public QrisGWBaseGenerator() {
		this.amount = null;
		this.convenienceFee = null;
		this.percentageTip = false;
	}

	public QrisGWBaseGenerator(BigDecimal amount, BigDecimal convenienceFee, boolean percentageTip) {
		this.amount = amount;
		this.convenienceFee = convenienceFee;
		this.percentageTip = percentageTip;

		if (MIN_TRANSACTION_AMOUNT == null) {
			MIN_TRANSACTION_AMOUNT = contextLoader.getQrisMinTransactionAmount();
		}

		if (MAX_TRANSACTION_AMOUNT == null) {
			MAX_TRANSACTION_AMOUNT = new BigDecimal(contextLoader.getQrisMaxTransactionAmount());
		}
	}

	public abstract HashMap<String, String> generateRequest() throws Exception;

	public BigDecimal getAmount() {
		return amount;
	}

	public String getAmountString() {
		return amount.toPlainString();
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getConvenienceFee() {
		return convenienceFee;
	}

	public String getConvenienceFeeString() {
		return convenienceFee.toPlainString();
	}

	public void setConvenienceFee(BigDecimal convenienceFee) {
		if (percentageTip) {
			if (convenienceFee == null) {
				this.convenienceFee = new BigDecimal("0.00");
			} else {
				this.convenienceFee = convenienceFee;
			}
		} else {
			this.convenienceFee = convenienceFee;
		}
	}

	public boolean isMerchantOnUs() {
		return merchantOnUs;
	}

	public void setMerchantOnUs(boolean merchantOnUs) {
		this.merchantOnUs = merchantOnUs;
	}

	public int getTransferTypeId() {
		return transferTypeId;
	}

	public void setTransferTypeId(int transferTypeId) {
		this.transferTypeId = transferTypeId;
	}

	public BigDecimal getTotalAmount() {
		if (percentageTip) {
			BigDecimal tipValue = amount.multiply(convenienceFee).divide(new BigDecimal(100)).setScale(2,
					RoundingMode.HALF_DOWN);
			return amount.add(tipValue);
		} else {
			if (convenienceFee == null) {
				return amount.setScale(2, RoundingMode.HALF_DOWN);
			}

			return amount.add(convenienceFee).setScale(2, RoundingMode.HALF_DOWN);
		}

	}

	public String getTotalAmountString() {
		return getTotalAmount().toPlainString();
	}

	public boolean isTotalAmountBelowMin() {
		BigDecimal totalAmount = getTotalAmount();

		if (totalAmount.compareTo(MIN_TRANSACTION_AMOUNT) < 0) {
			return true;
		}

		return false;
	}

	public boolean isTotalAmountAboveMax() {
		BigDecimal totalAmount = getTotalAmount();

		if (totalAmount.compareTo(MAX_TRANSACTION_AMOUNT) > 0) {
			return true;
		}

		return false;
	}

	public boolean isPercentageTip() {
		return percentageTip;
	}

	public void setPercentageTip(boolean percentageTip) {
		this.percentageTip = percentageTip;

		if (percentageTip) {
			if (convenienceFee == null) {
				convenienceFee = new BigDecimal("0.00");
			}
		}
	}

	public static BigDecimal getMinTransactionAmount() {
		if (MIN_TRANSACTION_AMOUNT == null) {
			MIN_TRANSACTION_AMOUNT = contextLoader.getQrisMinTransactionAmount();
		}

		return MIN_TRANSACTION_AMOUNT;
	}

	public static BigDecimal getMaxTransactionAmount() {
		if (MAX_TRANSACTION_AMOUNT == null) {
			MAX_TRANSACTION_AMOUNT = new BigDecimal(contextLoader.getQrisMaxTransactionAmount());
		}

		return MAX_TRANSACTION_AMOUNT;
	}
}
