package com.moneyxchange.persistence.dto;

import java.util.Date;

public class CurrencyDto {
	  private String id;
	  private Date inclusionDate;
	  
	  public CurrencyDto() {
	  }
	  
	  
	  
	public CurrencyDto(String id) {
		super();
		this.id = id;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getInclusionDate() {
		return inclusionDate;
	}
	public void setInclusionDate(Date inclusionDate) {
		this.inclusionDate = inclusionDate;
	}
	  
	  
}
