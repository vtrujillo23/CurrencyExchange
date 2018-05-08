package com.moneyxchange.persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.moneyxchange.persistence.config.PeristenceConfiguration;

@SpringBootApplication
@EnableAutoConfiguration
public class CurrencyExchangePersistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangePersistenceApplication.class, args);
	}
}
