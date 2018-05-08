package com.moneyxchange.core.manager;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneyxchange.core.component.ValidatorComponent;
import com.moneyxchange.core.dto.ErrorDto;
import com.moneyxchange.core.dto.MoneyExchangeDto;
import com.moneyxchange.core.dto.MoneyExchangeResponseDto;
import com.moneyxchange.core.exception.MoneyXChangeException;
import com.moneyxchange.core.util.Constants;
import com.moneyxchange.persistence.dto.CurrencyDto;
import com.moneyxchange.persistence.dto.ExchangeDto;
import com.moneyxchange.persistence.service.CurrencyService;
import com.moneyxchange.persistence.service.ExchangeService;

@Service
public class MoneyExchangeService {
	@Autowired
	private CurrencyService currencyService;
	@Autowired
	private ExchangeService exchangeService;
	@Autowired
	private Map<String, String> parameters;
	@Autowired
	private ValidatorComponent validatorComponent;
	

	public MoneyExchangeResponseDto doExchange(MoneyExchangeDto moneyExchangeDto) {
		MoneyExchangeResponseDto moneyExchangeResponseDto=new MoneyExchangeResponseDto(moneyExchangeDto);
		try {
			moneyExchangeResponseDto.setErrors(validatorComponent.validateMoneyExchangeDto(moneyExchangeDto));
			if(!moneyExchangeResponseDto.getErrors().isEmpty()) {
				return moneyExchangeResponseDto;
			}
			String timerefesh = parameters.get(Constants.TIMECURRENCYREFESH);
			int timerefeshint = 10;
			if (timerefesh != null) {
				timerefeshint = Integer.parseInt(timerefesh);
			}
			Date date1 = new Date();
			Date date2 = new Date(date1.getTime() + timerefeshint * 60 * 1000);
			CurrencyDto fromCurrency = new CurrencyDto(moneyExchangeDto.getFromCurrency());
			CurrencyDto toCurrency = new CurrencyDto(moneyExchangeDto.getToCurrency());
			List<ExchangeDto> resultado = exchangeService
					.findByFromcurrencyAndTocurrencyAndDateexchangeBetween(fromCurrency, toCurrency, date1, date2);
			if (resultado.isEmpty()) {	
				resultado = exchangeService.findByFromcurrencyAndTocurrencyOrderByDateexchange(fromCurrency,
						toCurrency);
				if (resultado.isEmpty()) {
					moneyExchangeResponseDto.getErrors().add(new ErrorDto("Rate of Change not found"));
					return moneyExchangeResponseDto;
				}
			}
			ExchangeDto exchangeDto = resultado.get(0);
			double result = Double.parseDouble(moneyExchangeDto.getFromAmmount()) * exchangeDto.getRate();
			NumberFormat formatter = new DecimalFormat("#0.0000");
			moneyExchangeResponseDto.setToAmmount(formatter.format(result));
			return moneyExchangeResponseDto;
		} catch (Exception e) {
			moneyExchangeResponseDto.getErrors().add(new ErrorDto("Error with application"));
			return moneyExchangeResponseDto;
		}
	}

	public CurrencyDto saveCurrency(CurrencyDto currencyDto) throws MoneyXChangeException {
		try {
			CurrencyDto currencyDtoSaved = currencyService.save(currencyDto);
			return currencyDtoSaved;
		} catch (Exception e) {
			throw new MoneyXChangeException(e, "Error en el aplicativo");
		}
	}

	public ExchangeDto saveExchange(ExchangeDto exchangeDto) throws MoneyXChangeException {
		try {
			ExchangeDto exchangeDtoSaved = exchangeService.save(exchangeDto);
			return exchangeDtoSaved;
		} catch (Exception e) {
			throw new MoneyXChangeException(e, "Error en el aplicativo");
		}
	}

}
