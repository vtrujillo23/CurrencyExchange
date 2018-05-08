package com.moneyxchange.core;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moneyxchange.core.conf.CurrencyExchangeConf;
import com.moneyxchange.core.dto.MoneyExchangeDto;
import com.moneyxchange.core.dto.MoneyExchangeResponseDto;
import com.moneyxchange.core.exception.MoneyXChangeException;
import com.moneyxchange.core.manager.MoneyExchangeService;


@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CurrencyExchangeConf.class)
public class CurrencyExchangeCoreApplicationTests {
	@Autowired
	private MoneyExchangeService moneyExchangeService;

	@Test
	public void contextLoads() {
		System.out.println("Context loaded");
	}
	
	@Test
	public void testConvert() throws MoneyXChangeException {
		MoneyExchangeDto moneyExchangeDto=new MoneyExchangeDto();
		moneyExchangeDto.setFromAmmount("25820.3");
		moneyExchangeDto.setFromCurrency("USD");
		moneyExchangeDto.setToCurrency("EUR");
		MoneyExchangeResponseDto moneyExchangeResDto=moneyExchangeService.doExchange(moneyExchangeDto);
		System.out.println("Exchange value "+moneyExchangeResDto.getToAmmount());
	}
	

}
