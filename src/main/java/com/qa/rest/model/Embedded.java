package com.qa.rest.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Embedded extends Model{

	@JsonProperty("customer")
	private List<CustomerItem> customer;

	public void setCustomer(List<CustomerItem> customer){
		this.customer = customer;
	}

	public List<CustomerItem> getCustomer(){
		return customer;
	}

	@Override
 	public String toString(){
		return 
			"Embedded{" + 
			"customer = '" + customer + '\'' + 
			"}";
		}
}