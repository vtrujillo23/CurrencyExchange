package com.moneyxchange.core.dto;

import java.util.ArrayList;
import java.util.List;

public class MoneyExchangeResponseDto extends MoneyExchangeDto{
	
	private List<ErrorDto> errors;
	private String toAmmount;
	
	
	public MoneyExchangeResponseDto(MoneyExchangeDto moneyExchangeDto) {
		this.setFromAmmount(moneyExchangeDto.getFromAmmount());
		this.setFromCurrency(moneyExchangeDto.getFromCurrency());
		this.setToCurrency(moneyExchangeDto.getToCurrency());
		errors=new ArrayList<ErrorDto>();
	}

	public List<ErrorDto> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDto> errors) {
		this.errors = errors;
	}

	public String getToAmmount() {
		return toAmmount;
	}

	public void setToAmmount(String toAmmount) {
		this.toAmmount = toAmmount;
	}
	
	
}
