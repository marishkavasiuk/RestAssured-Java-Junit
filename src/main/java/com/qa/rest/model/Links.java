package com.qa.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links extends Model{

	@JsonProperty("addresses")
	private Addresses addresses;

	@JsonProperty("cards")
	private Cards cards;

	@JsonProperty("self")
	private Self self;

	@JsonProperty("customer")
	private Customer customer;

	public void setAddresses(Addresses addresses){
		this.addresses = addresses;
	}

	public Addresses getAddresses(){
		return addresses;
	}

	public void setCards(Cards cards){
		this.cards = cards;
	}

	public Cards getCards(){
		return cards;
	}

	public void setSelf(Self self){
		this.self = self;
	}

	public Self getSelf(){
		return self;
	}

	public void setCustomer(Customer customer){
		this.customer = customer;
	}

	public Customer getCustomer(){
		return customer;
	}

	@Override
 	public String toString(){
		return 
			"Links{" + 
			"addresses = '" + addresses + '\'' + 
			",cards = '" + cards + '\'' + 
			",self = '" + self + '\'' + 
			",customer = '" + customer + '\'' + 
			"}";
		}
}