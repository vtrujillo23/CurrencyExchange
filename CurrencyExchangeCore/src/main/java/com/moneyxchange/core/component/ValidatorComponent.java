package com.moneyxchange.core.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.moneyxchange.core.dto.ErrorDto;
import com.moneyxchange.core.dto.MoneyExchangeDto;
import com.moneyxchange.core.util.RegularExpression;

@Component
public class ValidatorComponent {
	
	public  List<ErrorDto> validateMoneyExchangeDto(MoneyExchangeDto moneyExchangeDto){
		List<ErrorDto>  errors=new ArrayList<ErrorDto> ();
		if(moneyExchangeDto.getFromAmmount()==null || !moneyExchangeDto.getFromAmmount().matches(RegularExpression.NUMERIC)) {
			errors.add(new ErrorDto("From Ammount Invalid"));
		}
		return errors;
	}
	
	
}
