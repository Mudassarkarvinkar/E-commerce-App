package com.Ecommerce.RunningEcommerceApp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "country")
@Getter
@Setter

public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id ;
	 
	@Column(name = "code")
	private String code ;
	 
	
	@Column(name = "name")
	private String name;
	
	
	@OneToMany(mappedBy= "country")
	private List<State> state;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Country [id=" + id + ", code=" + code + ", name=" + name + "]";
	}


	public Country(int id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}
	
	public Country()
	{
		
	}

}
