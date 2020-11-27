package org.polytec.vermeg.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "customer")
public class Customer extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Bill> listBill;

	public Customer(int idCustomer, String last_name, String first_name, int cin, int tel, String role) {
		super(idCustomer, last_name, first_name, cin, tel, role);
	}

	@JsonManagedReference
	public List<Bill> getListBill() {
		return listBill;
	}

	public void setListBill(List<Bill> listBill) {
		this.listBill = listBill;
	}

}
