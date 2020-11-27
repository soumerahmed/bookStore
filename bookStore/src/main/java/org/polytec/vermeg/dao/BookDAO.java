package org.polytec.vermeg.dao;

import java.util.List;
import org.polytec.vermeg.model.Book;

public interface BookDAO {

	void addBook(Book book);

	Book findBookById(int id);

	List<Book> findAllBook();

	void deleteBook(Book book);

	void updateBook(Book book);

}
