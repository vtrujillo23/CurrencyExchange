package com.moneyxchange.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.moneyxchange.persistence.entities.Parameters;

public interface ParameterDao extends CrudRepository<Parameters, String>{

}
