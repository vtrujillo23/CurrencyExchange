package com.moneyxchange.core.tasks;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moneyxchange.client.restclient.ConvertionConsumer;
import com.moneyxchange.persistence.dto.CurrencyconverurlDto;
import com.moneyxchange.persistence.dto.ExchangeDto;
import com.moneyxchange.persistence.service.CurrencyconverurlService;
import com.moneyxchange.persistence.service.ExchangeService;

@Component
public class RatesRefeshTask implements Runnable{
	private static final String FROMVARIABLE="base";
	private static final String TOVARIABLE="symbols";
	
	@Autowired
	private ConvertionConsumer convertionConsumer;
	@Autowired
	private ExchangeService exchangeService;
	@Autowired
	private CurrencyconverurlService currencyconverurlService;

	@Override
	public void run() {
		List<CurrencyconverurlDto> resultado=currencyconverurlService.findAll();
		resultado.forEach((convurl)->{
			try {
			ResponseObject responseObject=convertionConsumer.getRate(convurl.getUrlvalue(), convurl.getCurrency1().getId(), convurl.getCurrency().getId(), FROMVARIABLE, TOVARIABLE);
			ExchangeDto exchangeDto=new ExchangeDto();
			exchangeDto.setActive(true);
			exchangeDto.setDateexchange(new Date());
			exchangeDto.setFromcurrency(convurl.getCurrency1());
			exchangeDto.setTocurrency(convurl.getCurrency());
			exchangeDto.setRate(responseObject.getRates().get(convurl.getCurrency().getId()));
			exchangeService.save(exchangeDto);
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
	}

}
