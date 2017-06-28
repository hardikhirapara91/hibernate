package com.hardik.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	private long studentId;
	private String studentName;
	private Set<Course> courses = new HashSet<Course>(0);

	public Student() {
	}

	public Student(String studentName) {
		this.studentName = studentName;
	}

	public Student(String studentName, Set<Course> courses) {
		this.studentName = studentName;
		this.courses = courses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	@Column(name = "student_name", nullable = false, length = 100)
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
			@JoinColumn(name = "course_id") })
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
