package org.polytec.vermeg.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProduct;
	@Column(name = "productDesignation")
	private String productDesignation;
	@Column(name = "productReference")
	private String productReference;
	@Column(name = "quatiteInStock")
	private int quatiteInStock;
	@Column(name = "price")
	private double price;
	@JsonIgnore

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "product")
	private List<LineCommand> listLineCommand;

	public Product() {
	}

	public Product(int idProduct, String productDesignation, String productReference, int quatiteInStock, double price,
			String bookTitle, String bookAuthor) {

		this.idProduct = idProduct;
		this.productDesignation = productDesignation;
		this.productReference = productReference;
		this.quatiteInStock = quatiteInStock;
		this.price = price;
	}

	public Product(int idBook, String productDesignation, String productReference, int quatiteInStock, double price) {
		this.idProduct = idBook;
		this.productDesignation = productDesignation;
		this.productReference = productReference;
		this.quatiteInStock = quatiteInStock;
		this.price = price;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductDesignation() {
		return productDesignation;
	}

	public void setProductDesignation(String productDesignation) {
		this.productDesignation = productDesignation;
	}

	public String getProductReference() {
		return productReference;
	}

	public void setProductReference(String productReference) {
		this.productReference = productReference;
	}

	public int getQuatiteInStock() {
		return quatiteInStock;
	}

	public void setQuatiteInStock(int quatiteInStock) {
		this.quatiteInStock = quatiteInStock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@JsonManagedReference
	public List<LineCommand> getListLineCommand() {
		return listLineCommand;
	}

	public void setListLineCommand(List<LineCommand> listLineCommand) {
		this.listLineCommand = listLineCommand;
	}

	public String toString() {

		return "le prix " + this.getIdProduct();

	}
}
