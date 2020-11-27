package org.polytec.vermeg.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.polytec.vermeg.model.Bill;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "lineCommand")
public class LineCommand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLineCommand;

	@Column(name = "quantity")
	private int quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduct", nullable = false)
	private Product product;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idBill", nullable = false)
	private Bill bill;

	LineCommand() {
	}

	public LineCommand(int idLineCommand, int qt, Product product, Bill bill) {
		this.idLineCommand = idLineCommand;
		this.quantity = qt;
		this.product = product;
		this.bill = bill;
	}

	public int getIdLineCommand() {
		return idLineCommand;
	}

	public void setIdLineCommand(int idLineCommand) {
		this.idLineCommand = idLineCommand;
	}

	public int getQt() {
		return quantity;
	}

	public void setQt(int qt) {
		this.quantity = qt;
	}

	@JsonBackReference
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@JsonBackReference
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

}
