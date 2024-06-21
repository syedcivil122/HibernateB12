package com.tejait.hibernate.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "items_b12")
public class Iteams {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iid;
	private String name;
	private int price;
	
	@ManyToMany
	@JoinTable(name ="customer_items_b12",
	joinColumns = {@JoinColumn(name="iid")},
	inverseJoinColumns = {@JoinColumn(name="cid")})
	
	private List<Customer> custom;

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Customer> getCustom() {
		return custom;
	}

	public void setCustom(List<Customer> custom) {
		this.custom = custom;
	}
	
	
	
	

}
