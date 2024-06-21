package com.tejait.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="customer_b12")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	private long mobileNum;
	private String city;
	

	@OneToOne(mappedBy = "cust", cascade = CascadeType.ALL)
	private Wallet wal;

	@OneToMany(mappedBy = "cus", cascade = CascadeType.ALL)
	private List<Orders> ord;
	
	
	@ManyToMany(mappedBy = "custom", cascade = CascadeType.ALL)
	private List<Iteams> itms;
	
	public int getCid() {
		return cid;
	}

	public List<Iteams> getItms() {
		return itms;
	}

	public void setItms(List<Iteams> itms) {
		this.itms = itms;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getCity() {
		return city; 
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Wallet getWal() {
		return wal;
	}

	public void setWal(Wallet wal) {
		this.wal = wal;
	}

	public List<Orders> getOrd() {
		return ord;
	}

	public void setOrd(List<Orders> ord) {
		this.ord = ord;
	}

	
	
	
	
	

}
