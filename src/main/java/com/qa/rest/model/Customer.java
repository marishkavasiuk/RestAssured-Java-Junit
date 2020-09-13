package com.qa.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer extends Model{

	@JsonProperty("href")
	private String href;

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	@Override
 	public String toString(){
		return 
			"Customer{" + 
			"href = '" + href + '\'' + 
			"}";
		}
}