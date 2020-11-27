package org.polytec.vermeg.service;

import java.util.List;
import org.polytec.vermeg.model.Book;
import org.springframework.transaction.annotation.Transactional;

public interface BookService {

	@Transactional
	public List<Book> findAllBookService();

	@Transactional
	public Book findBookByIdService(int id);

	@Transactional
	public void addBookService(Book book);

	@Transactional
	public void updateBookService(Book book);

	@Transactional
	void deleteBookService(Book book);
}
