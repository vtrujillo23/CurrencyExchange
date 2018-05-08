package com.moneyxchange.persistence.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneyxchange.persistence.dao.CurrencyconverurlDao;
import com.moneyxchange.persistence.dto.CurrencyconverurlDto;
import com.moneyxchange.persistence.entities.Currencyconverurl;
import com.moneyxchange.persistence.entities.CurrencyconverurlPK;


@Service
public class CurrencyconverurlService extends AbstractService<Currencyconverurl,CurrencyconverurlDto,CurrencyconverurlPK>{
	@Autowired
	private CurrencyconverurlDao currencyconverurlDao;
	@Autowired
	public CurrencyconverurlService(){
		this.typeS=CurrencyconverurlDto.class;
		this.typeT=Currencyconverurl.class;
	}
	
	@PostConstruct
	private void initDao() {
		this.crudRepository=currencyconverurlDao;
	}
}
