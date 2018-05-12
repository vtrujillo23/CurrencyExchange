package com.moneyxchange.persistence.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moneyxchange.persistence.entities.Currency;
import com.moneyxchange.persistence.entities.Exchange;


@Repository
public interface ExchangeDao extends CrudRepository<Exchange, Integer>{
	public List<Exchange> findByFromcurrencyAndTocurrencyAndDateexchangeBetween(Currency fromCurrency,Currency toCurrency,Date date1,Date date2);
	public List<Exchange> findByFromcurrencyAndTocurrencyOrderByDateexchangeDesc(Currency fromCurrency,Currency toCurrency,Pageable topOne);
}
