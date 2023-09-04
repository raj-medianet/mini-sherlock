package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Datasource {

	@Id
	String name;
	String url;

	public Datasource() {
		// TODO Auto-generated constructor stub
	}

	public Datasource(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
