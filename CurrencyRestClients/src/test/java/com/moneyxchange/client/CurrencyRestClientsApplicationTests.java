package com.moneyxchange.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.moneyxchange.client.conf.ClientsConf;
import com.moneyxchange.client.dto.ResponseObject;
import com.moneyxchange.client.restclient.ConvertionConsumer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ClientsConf.class)
public class CurrencyRestClientsApplicationTests {
	@Autowired
	private ConvertionConsumer convertionConsumer;
	
	
	@Test
	public void testClient() throws Exception {
		ResponseObject responseObject=convertionConsumer.getRate("http://api.fixer.io/latest", "USD", "EUR", "base", "symbols");
		System.out.println("Salida de rate "+responseObject.getRates().size());	
	}

}
