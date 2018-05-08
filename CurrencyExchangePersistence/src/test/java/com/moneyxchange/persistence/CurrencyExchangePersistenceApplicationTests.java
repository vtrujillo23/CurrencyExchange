package com.moneyxchange.persistence;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.moneyxchange.persistence.config.PeristenceConfiguration;
import com.moneyxchange.persistence.dao.CurrencyDao;
import com.moneyxchange.persistence.dao.ExchangeDao;
import com.moneyxchange.persistence.dto.CurrencyDto;
import com.moneyxchange.persistence.dto.ExchangeDto;
import com.moneyxchange.persistence.entities.Currency;
import com.moneyxchange.persistence.entities.Exchange;
import com.moneyxchange.persistence.service.CurrencyService;
import com.moneyxchange.persistence.service.ExchangeService;


@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PeristenceConfiguration.class)
public class CurrencyExchangePersistenceApplicationTests {
	@Autowired
	private CurrencyService currencyService;
	@Autowired
	private ExchangeService exchangeService;
	
	@Test
	public void persistenceTest() {
		CurrencyDto currencyUSD=new CurrencyDto();
		currencyUSD.setId("USD");
		currencyUSD.setInclusionDate(new Date());
		CurrencyDto currencyEUR=new CurrencyDto();
		currencyEUR.setId("EUR");
		currencyEUR.setInclusionDate(new Date());
		currencyService.save(currencyUSD);
		currencyService.save(currencyEUR);
		Date date=new Date();
		ExchangeDto exchange=new ExchangeDto();
		exchange.setFromcurrency(currencyUSD);
		exchange.setTocurrency(currencyEUR);
		exchange.setRate(1.26);
		exchange.setDateexchange(date);
		exchange.setActive(true);
		ExchangeDto exchangeDtosaved=exchangeService.save(exchange);
		Date date2=new Date(date.getTime()+10*60*1000);
		List<ExchangeDto> exchangefounded=exchangeService.findByFromcurrencyAndTocurrencyAndDateexchangeBetween(currencyUSD, currencyEUR, date,date2);
		exchangefounded.forEach((exch)->{
			System.out.println("Salida del exchange "+exch.getRate());
		});
		exchangeService.delete(exchangeDtosaved);
		currencyService.delete(currencyUSD);
		currencyService.delete(currencyEUR);
	}

}
