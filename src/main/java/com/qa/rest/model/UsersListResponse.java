package com.qa.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersListResponse extends Model{

	@JsonProperty("_embedded")
	private Embedded embedded;

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("page")
	private Page page;

	public void setEmbedded(Embedded embedded){
		this.embedded = embedded;
	}

	public Embedded getEmbedded(){
		return embedded;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setPage(Page page){
		this.page = page;
	}

	public Page getPage(){
		return page;
	}

	@Override
 	public String toString(){
		return 
			"UsersListResponse{" + 
			"_embedded = '" + embedded + '\'' + 
			",_links = '" + links + '\'' + 
			",page = '" + page + '\'' + 
			"}";
		}
}