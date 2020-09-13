package com.qa.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPayload extends Model {

	@JsonProperty("password")
	private String password;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;

	public UserPayload(String password, String email, String username) {
		this.password = password;
		this.email = email;
		this.username = username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return
			"UserPayload{" +
			"password = '" + password + '\'' +
			",email = '" + email + '\'' +
			",username = '" + username + '\'' +
			"}";
		}
}