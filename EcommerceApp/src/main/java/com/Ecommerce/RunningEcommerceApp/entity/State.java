package com.Ecommerce.RunningEcommerceApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "state")
//@Getter
//@Setter
public class State {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "name")
	private String name;
	
	
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + "]";
	}


	public State(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public State()
	{
		
	}
	

}
