package com.moneyxchange.persistence.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneyxchange.persistence.dao.ParameterDao;
import com.moneyxchange.persistence.dto.ParametersDto;
import com.moneyxchange.persistence.entities.Parameters;

@Service
public class ParametersService extends AbstractService<Parameters,ParametersDto,String>{
	@Autowired
	private ParameterDao parameterDao;
	
	@Autowired
	public ParametersService(){
		this.typeS=ParametersDto.class;
		this.typeT=Parameters.class;
	}
	
	@PostConstruct
	private void initDao() {
		this.crudRepository=parameterDao;
	}
}
