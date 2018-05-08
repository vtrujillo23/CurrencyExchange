package com.moneyxchange.core.exception;

public class MoneyXChangeException extends Exception{

	private static final long serialVersionUID = 1L;
	private String detailMessage;
	
	public MoneyXChangeException(Throwable throwable,String detailMessage) {
		super(throwable);
		this.detailMessage=detailMessage;
	}
	
	public MoneyXChangeException(String detailMessage) {
		super();
		this.detailMessage=detailMessage;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}
	
	

}
