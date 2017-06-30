package com.hardik.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 * Employee
 * 
 * @author HARDIK
 *
 */
@NamedNativeQueries({
		@NamedNativeQuery(name = "findEmployeeBySalary", query = "SELECT * FROM employee e WHERE e.salary=:salary", resultClass = Employee.class) })
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	@Column(name = "dept", nullable = false, length = 100)
	private String dept;
	@Column(name = "salary", nullable = false)
	private int salary;

	public Employee() {
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + getId() + ", name=" + getName() + ", dept=" + getDept() + ", salary=" + getSalary()
				+ "]";
	}
}
