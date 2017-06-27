package com.hardik.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User Model
 * 
 * @author HARDIK HIRAPARA
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false, precision = 5, scale = 0)
	private int id;

	@Column(name = "name", nullable = false, length = 100)
	private String username;

	@Column(name = "created_by", nullable = false, length = 100)
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "created_date", nullable = false, length = 7)
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
