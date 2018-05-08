package com.moneyxchange.rest.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.moneyxchange.core.conf.CurrencyExchangeConf;

@Configuration
@Import({CurrencyExchangeConf.class})
@ComponentScan({"com.moneyxchange.rest.controller"})
public class CurrencyExchangeRestConf {

}
