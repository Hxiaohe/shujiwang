package service;

import domain.Book;

import java.util.List;

public interface IBookService {
	public void alterBook(Book book);
	//���ע���û���Ϣ�����ݿ�
	public void addBook(Book book);

	//�����û���Ż�ȡ�û���Ϣ
	public Book getBookByID(String id);
	
	
	public List<Book> getBookBybookName(String bookName);
	
	public List<Book> getAllBooks();
	public boolean isUpAllBooks();
}

