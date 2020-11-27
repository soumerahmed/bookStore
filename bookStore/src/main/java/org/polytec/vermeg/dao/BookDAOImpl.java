package org.polytec.vermeg.dao;

import java.util.List;
import org.polytec.vermeg.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl extends AbstractHibernateDAO<Book> implements BookDAO {

	public BookDAOImpl() {
		setClazz(Book.class);
	}

	@Override
	public void addBook(Book book) {
		super.save(book);
	}

	@Override
	public Book findBookById(int id) {
		return super.findOne(id);
	}

	@Override
	public List<Book> findAllBook() {
		return super.findAll();
	}

	@Override
	public void deleteBook(Book book) {
		super.delete(book);
	}

	@Override
	public void updateBook(Book book) {
		super.update(book);
	}

}
