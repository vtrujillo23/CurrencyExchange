package com.moneyxchange.persistence.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.moneyxchange.persistence.dao.ExchangeDao;
import com.moneyxchange.persistence.dto.CurrencyDto;
import com.moneyxchange.persistence.dto.ExchangeDto;
import com.moneyxchange.persistence.entities.Currency;
import com.moneyxchange.persistence.entities.Exchange;
import com.moneyxchange.persistence.util.ObjectUtil;


@Service
public class ExchangeService extends AbstractService<Exchange,ExchangeDto,Integer>{
	@Autowired
	private ExchangeDao exchangeDao;
	
	public ExchangeService() {
		this.typeS=ExchangeDto.class;
		this.typeT=Exchange.class;
	}
	
	
	@PostConstruct
	private void initDao() {
		this.crudRepository=exchangeDao;
	}
	
	public List<ExchangeDto> findByFromcurrencyAndTocurrencyAndDateexchangeBetween(CurrencyDto fromCurrency,CurrencyDto toCurrency,Date date1,Date date2){
		List<Exchange> list=exchangeDao.findByFromcurrencyAndTocurrencyAndDateexchangeBetween((Currency) ObjectUtil.convertObject(CurrencyDto.class, Currency.class, fromCurrency), (Currency) ObjectUtil.convertObject(CurrencyDto.class, Currency.class, toCurrency), date1, date2);
		List<ExchangeDto> result=new ArrayList<ExchangeDto>();
		list.forEach((exch)->{
			result.add((ExchangeDto) ObjectUtil.convertObject(Exchange.class, ExchangeDto.class, exch));
		});
		return result;
	}
	
	public List<ExchangeDto> findByFromcurrencyAndTocurrencyOrderByDateexchange(CurrencyDto fromCurrency,CurrencyDto toCurrency){
		List<Exchange> list=exchangeDao.findByFromcurrencyAndTocurrencyOrderByDateexchangeDesc((Currency) ObjectUtil.convertObject(CurrencyDto.class, Currency.class, fromCurrency), (Currency) ObjectUtil.convertObject(CurrencyDto.class, Currency.class, toCurrency),PageRequest.of(0,1));
		List<ExchangeDto> result=new ArrayList<ExchangeDto>();
		list.forEach((exch)->{
			result.add((ExchangeDto) ObjectUtil.convertObject(Exchange.class, ExchangeDto.class, exch));
		});
		return result;
	}
	
	
	
}
