package org.polytec.vermeg.controller;

import java.util.List;

import org.polytec.vermeg.model.Book;
import org.polytec.vermeg.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<Book> findAllBook() {
		return bookService.findAllBookService();
	}

	@RequestMapping(value = "/getBook/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Book findBookById(@PathVariable int id) {
		return bookService.findBookByIdService(id);
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addBook(@ModelAttribute("product") Book book) {
		if (book.getIdProduct() == 0) {
			bookService.addBookService(book);
		} else {
			bookService.updateBookService(book);
		}

		return "add with success";
	}

	@RequestMapping(value = "/updateBook/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateBook(@PathVariable("id") int id, @RequestBody Book book) {
		if (bookService.findBookByIdService(id) == null) {
			return " Book Not exist ";
		} else {

			bookService.updateBookService(bookService.findBookByIdService(id));
			return " Update with succes";
		}
	}

	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteBook(@PathVariable("id") int id) {
		bookService.deleteBookService(bookService.findBookByIdService(id));
		return "deleted with succes";

	}
}
