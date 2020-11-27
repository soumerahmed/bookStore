package org.polytec.vermeg.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "administrator")
public class Administrator extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public Administrator() {
	}

	public Administrator(int idAdministrator, String last_name, String first_name, int cin, int tel, String role) {
		super(idAdministrator, last_name, first_name, cin, tel, role);
	}

}
