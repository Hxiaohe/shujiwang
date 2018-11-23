package service;

import domain.Book;

import java.util.List;

public interface IBookService {
	 void alterBook(Book book);

	 void addBook(Book book);

	 Book getBookByID(String id);
	
	
	 List<Book> getBookBybookName(String bookName);
	
	 List<Book> getAllBooks();

	 boolean isUpAllBooks();

    List<Book> searchBooks(String input);


}

