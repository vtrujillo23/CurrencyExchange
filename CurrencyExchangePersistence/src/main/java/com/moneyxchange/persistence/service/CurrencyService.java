package com.moneyxchange.persistence.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneyxchange.persistence.dao.CurrencyDao;
import com.moneyxchange.persistence.dto.CurrencyDto;
import com.moneyxchange.persistence.entities.Currency;

@Service
public class CurrencyService extends AbstractService<Currency,CurrencyDto,String>{
	@Autowired
	private CurrencyDao currencyDao;
	@Autowired
	public CurrencyService(){
		this.typeS=CurrencyDto.class;
		this.typeT=Currency.class;
	}
	
	@PostConstruct
	private void initDao() {
		this.crudRepository=currencyDao;
	}
}
