package com.moneyxchange.persistence.dto;


public class CurrencyconverurlDto {
	    protected CurrencyconverurlPKDto currencyconverurlPK;
	    private String urlvalue;
	    private CurrencyDto currency;
	    private CurrencyDto currency1;
		public CurrencyconverurlPKDto getCurrencyconverurlPK() {
			return currencyconverurlPK;
		}
		public void setCurrencyconverurlPK(CurrencyconverurlPKDto currencyconverurlPK) {
			this.currencyconverurlPK = currencyconverurlPK;
		}
		public String getUrlvalue() {
			return urlvalue;
		}
		public void setUrlvalue(String urlvalue) {
			this.urlvalue = urlvalue;
		}
		public CurrencyDto getCurrency() {
			return currency;
		}
		public void setCurrency(CurrencyDto currency) {
			this.currency = currency;
		}
		public CurrencyDto getCurrency1() {
			return currency1;
		}
		public void setCurrency1(CurrencyDto currency1) {
			this.currency1 = currency1;
		}
	    
	    
}
