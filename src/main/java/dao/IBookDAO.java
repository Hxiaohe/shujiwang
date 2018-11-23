package dao;

import domain.Book;

import java.util.List;

public interface IBookDAO {
		 void addBook(Book book);

		 void alterBook(Book book);

		 Book getBookById(String id);

		 List<Book> getBookByBookName(String bookName);

		 boolean isUpAllBooks();

		 List<Book> getAllBooks();

		 List<Book> searchBooks(String input);
}
