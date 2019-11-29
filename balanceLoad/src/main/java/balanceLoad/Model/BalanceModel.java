package balanceLoad.Model;

import java.sql.Timestamp;

public class BalanceModel {

	private Timestamp timeStamp;
	private Integer creditAmount=0;
	private Integer debitAmount=0;
	private Integer  amountNet=0;
	
	public BalanceModel() {
		
	}

	public BalanceModel(Timestamp timeStamp, Integer creditAmount, Integer debitAmount, Integer amountNet) {
		super();
		this.timeStamp = timeStamp;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.amountNet = amountNet;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Integer creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Integer getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Integer debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Integer getAmountNet() {
		return amountNet;
	}

	public void setAmountNet(Integer amountNet) {
		this.amountNet = amountNet;
	}

	@Override
	public String toString() {
		return "BalanceModel [timeStamp=" + timeStamp + ", creditAmount=" + creditAmount + ", debitAmount="
				+ debitAmount + ", amountNet=" + amountNet + "]";
	}

	

	
}
