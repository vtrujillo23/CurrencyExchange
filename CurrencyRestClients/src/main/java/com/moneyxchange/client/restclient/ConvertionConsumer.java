package com.moneyxchange.client.restclient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.moneyxchange.client.dto.ResponseObject;

@Component
public class ConvertionConsumer {
	
	
	public ResponseObject getRate(String url,String fromCurrency,String toCurrency,String formvarname,String tovarname) throws Exception{
		RestTemplate restTemplate = new RestTemplate();
		String urlserv=url+"?"+formvarname+"="+fromCurrency+"&"+tovarname+"="+toCurrency;
		ResponseEntity<ResponseObject> response = restTemplate.getForEntity(urlserv, ResponseObject.class);
		return response.getBody();
	}
	
}
