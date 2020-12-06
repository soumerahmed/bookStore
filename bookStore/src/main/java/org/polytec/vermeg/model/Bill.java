package org.polytec.vermeg.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "bill")
public class Bill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idBill;
	@Column(name = "titalPrice")
	private double totalPrice;
	@Column(name = "date")
	private Date date;
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "bill")
	private List<LineCommand> listLineCommand;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCustomer", nullable = false)
	private Customer customer;

	public Bill() {
	}
	

	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@JsonManagedReference
	public List<LineCommand> getListLineCommand() {
		return listLineCommand;
	}

	public void setListLineCommand(List<LineCommand> listLineCommand) {
		this.listLineCommand = listLineCommand;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
