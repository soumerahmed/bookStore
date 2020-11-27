package org.polytec.vermeg.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "person")
public class Person implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPerson;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "cin")
	private int cin;
	@Column(name = "tel")
	private int tel;
	@Column(name = "role")
	private String role;

	public Person() {
	}

	public Person(int idPerson, String last_name, String first_name, int cin, int tel, String role) {
		this.idPerson = idPerson;
		this.last_name = last_name;
		this.first_name = first_name;
		this.cin = cin;
		this.tel = tel;
		this.role = role;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
