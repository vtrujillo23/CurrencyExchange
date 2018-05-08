package com.moneyxchange.persistence.dto;

import java.util.Date;



public class ExchangeDto {
	    private Double rate;
	    private Date dateexchange;
	    private Integer id;
	    private Boolean active;
	    private CurrencyDto fromcurrency;
	    private CurrencyDto tocurrency;
	    
		public Double getRate() {
			return rate;
		}
		public void setRate(Double rate) {
			this.rate = rate;
		}
		public Date getDateexchange() {
			return dateexchange;
		}
		public void setDateexchange(Date dateexchange) {
			this.dateexchange = dateexchange;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Boolean getActive() {
			return active;
		}
		public void setActive(Boolean active) {
			this.active = active;
		}
		public CurrencyDto getFromcurrency() {
			return fromcurrency;
		}
		public void setFromcurrency(CurrencyDto fromcurrency) {
			this.fromcurrency = fromcurrency;
		}
		public CurrencyDto getTocurrency() {
			return tocurrency;
		}
		public void setTocurrency(CurrencyDto tocurrency) {
			this.tocurrency = tocurrency;
		}
	    
	    
}
