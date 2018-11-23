package service.imp;

import dao.IBookDAO;
import dao.imp.BookDAO;
import domain.Book;
import service.IBookService;

import java.util.List;

public class BookService implements IBookService {
	private IBookDAO bookDAO = new BookDAO();
	


			public BookService() {
		
	}
	@Override
	public void alterBook(Book book) {
		bookDAO.alterBook(book);

	}

	@Override
	public void addBook(Book book) {
		bookDAO.addBook(book);

	}

	@Override
	public Book getBookByID(String id) {
		return bookDAO.getBookById(id);
	}

	@Override
	public List<Book> getBookBybookName(String bookName) {
		return bookDAO.getBookByBookName(bookName);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDAO.getAllBooks();
	}
	
	@Override
	public boolean isUpAllBooks(){
		return bookDAO.isUpAllBooks();
	}

	@Override
	public List<Book> searchBooks(String input) {
		return bookDAO.searchBooks(input);
	}

}
