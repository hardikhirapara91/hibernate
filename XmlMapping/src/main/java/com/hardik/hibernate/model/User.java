package com.hardik.hibernate.model;

import java.io.Serializable;
import java.util.Date;

/**
 * User Model
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String username;
	private String createdBy;
	private Date createdDate;

	// Constructors
	public User() {
	}

	User(int id, String username, String createdBy, Date createdDate) {
		this.id = id;
		this.username = username;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	// Getters & Setters

}
