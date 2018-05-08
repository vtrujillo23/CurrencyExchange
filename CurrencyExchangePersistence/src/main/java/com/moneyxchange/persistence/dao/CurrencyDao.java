package com.moneyxchange.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moneyxchange.persistence.entities.Currency;

@Repository
public interface CurrencyDao extends CrudRepository<Currency,String>{
}
