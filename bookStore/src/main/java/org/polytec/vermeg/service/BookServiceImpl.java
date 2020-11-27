package org.polytec.vermeg.service;

import java.util.List;

import org.polytec.vermeg.dao.BookDAO;
import org.polytec.vermeg.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;

	@Override
	public List<Book> findAllBookService() {
		return bookDAO.findAllBook();
	}

	@Override
	public Book findBookByIdService(int id) {
		return bookDAO.findBookById(id);
	}

	@Override
	public void addBookService(Book book) {
		bookDAO.addBook(book);

	}

	@Override
	public void updateBookService(Book book) {
		bookDAO.updateBook(book);
	}

	@Override
	public void deleteBookService(Book book) {
		bookDAO.deleteBook(book);
	}

}
