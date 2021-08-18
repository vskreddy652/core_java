package com.example99.entity;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	private int id;
	private String name;
	private String addr;
	private String contactnum;
	private String emailid;

	public Customer() {}
	public Customer(int id, String name, String addr, String contactnum, String emailid) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.contactnum = contactnum;
		this.emailid = emailid;
	}

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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getContactnum() {
		return contactnum;
	}

	public void setContactnum(String contactnum) {
		this.contactnum = contactnum;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
}
