package org.polytec.vermeg.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book extends Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "bookTitle")
	private String bookTitle;
	@Column(name = "bookAuthor")
	private String bookAuthor;
	@Column(name = "dateEdition")
	private Date dateEdition;

	public Book(int idBook, String productDesignation, String productReference, int quatiteInStock, double price,
			String title, String author, Date dateEdition) {
		super(idBook, productDesignation, productReference, quatiteInStock, price);
		this.bookTitle = title;
		this.bookAuthor = author;
		this.dateEdition = dateEdition;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Date getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(Date dateEdition) {
		this.dateEdition = dateEdition;
	}

}
