package com.moneyxchange.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moneyxchange.core.dto.MoneyExchangeDto;
import com.moneyxchange.core.dto.MoneyExchangeResponseDto;
import com.moneyxchange.core.manager.MoneyExchangeService;

@RestController
public class MoneyExchangeController {
	private static final String DOEXCHANGEPATH="/exchange";
	
	@Autowired
	private MoneyExchangeService moneyExchangeService;
	
	
	@RequestMapping(value =DOEXCHANGEPATH , method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MoneyExchangeResponseDto> exchange(@RequestBody MoneyExchangeDto moneyExchangeDto){
		MoneyExchangeResponseDto moneyExchangeResponseDto=moneyExchangeService.doExchange(moneyExchangeDto);
		return new ResponseEntity<MoneyExchangeResponseDto>(moneyExchangeResponseDto,HttpStatus.OK);
	}
	
	
	
	
}
