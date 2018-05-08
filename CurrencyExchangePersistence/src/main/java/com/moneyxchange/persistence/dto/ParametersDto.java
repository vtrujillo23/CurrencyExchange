package com.moneyxchange.persistence.dto;


public class ParametersDto {
	private String paramkey;
    private String paramvalue;
	
    public ParametersDto() {
    }
    
    public ParametersDto(String paramkey, String paramvalue) {
		super();
		this.paramkey = paramkey;
		this.paramvalue = paramvalue;
	}



	public String getParamkey() {
		return paramkey;
	}
	public void setParamkey(String paramkey) {
		this.paramkey = paramkey;
	}
	public String getParamvalue() {
		return paramvalue;
	}
	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}
    
    
}
