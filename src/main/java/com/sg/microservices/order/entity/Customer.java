package com.sg.microservices.order.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private long  customerid;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private long phnumber;

	
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", username=" + username
				+ ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", address="
				+ address + ", phnumber=" + phnumber + "]";
	}

	public Customer(long customerid, String username, String password,
			String firstname, String lastname, String email, String address,
			long phnumber) {
		super();
		this.customerid = customerid;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.phnumber = phnumber;
	}

	
public Customer(){
	
}
	

}
