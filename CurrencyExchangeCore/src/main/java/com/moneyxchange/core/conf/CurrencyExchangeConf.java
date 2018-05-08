package com.moneyxchange.core.conf;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;

import com.moneyxchange.client.conf.ClientsConf;
import com.moneyxchange.core.tasks.RatesRefeshTask;
import com.moneyxchange.core.util.Constants;
import com.moneyxchange.persistence.config.PeristenceConfiguration;
import com.moneyxchange.persistence.service.ParametersService;

@Configuration
@Import({PeristenceConfiguration.class,ClientsConf.class})
@ComponentScan({ "com.moneyxchange.core.manager" , "com.moneyxchange.core.tasks","com.moneyxchange.core.component" })
public class CurrencyExchangeConf {
	
	@Autowired
	private ParametersService parametersService;
	
	@Autowired
	private RatesRefeshTask ratesRefeshTask;
	
	
	@PostConstruct
	public void init() {
		ThreadPoolTaskScheduler threadPoolTaskScheduler=threadPoolTaskScheduler();
		String timerefesh= getParameters().get(Constants.TIMECURRENCYREFESH);
		int timerefeshint=10;
		if(timerefesh!=null) {
			timerefeshint=Integer.parseInt(timerefesh);
		}
		PeriodicTrigger periodicTrigger = new PeriodicTrigger(timerefeshint, TimeUnit.MINUTES);
		threadPoolTaskScheduler.schedule(ratesRefeshTask, periodicTrigger);
	}
	

	@Bean
	@Autowired
	public Map<String, String> getParameters() {
		Map<String, String> result = new HashMap<String, String>();
		parametersService.findAll().forEach((param) -> {
			result.put(param.getParamkey(), param.getParamvalue());
		});
		return result;
	}

	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(5);
		threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
		return threadPoolTaskScheduler;
	}

}
