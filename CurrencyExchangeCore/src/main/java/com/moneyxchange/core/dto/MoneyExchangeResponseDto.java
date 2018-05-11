package com.moneyxchange.core.dto;

import java.util.ArrayList;
import java.util.List;

public class MoneyExchangeResponseDto extends MoneyExchangeDto{
	
	private List<String> errors;
	private String toAmmount;
	
	
	public MoneyExchangeResponseDto(MoneyExchangeDto moneyExchangeDto) {
		this.setFromAmmount(moneyExchangeDto.getFromAmmount());
		this.setFromCurrency(moneyExchangeDto.getFromCurrency());
		this.setToCurrency(moneyExchangeDto.getToCurrency());
		errors=new ArrayList<String>();
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String getToAmmount() {
		return toAmmount;
	}

	public void setToAmmount(String toAmmount) {
		this.toAmmount = toAmmount;
	}
	
	
}
