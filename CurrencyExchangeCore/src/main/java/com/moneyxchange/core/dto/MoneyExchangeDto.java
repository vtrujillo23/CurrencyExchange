package com.moneyxchange.core.dto;

public class MoneyExchangeDto {
	private String fromAmmount;
	private String fromCurrency;
	private String toCurrency;
	public String getFromAmmount() {
		return fromAmmount;
	}
	public void setFromAmmount(String fromAmmount) {
		this.fromAmmount = fromAmmount;
	}
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	
	
}
