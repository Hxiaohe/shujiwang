package dao;

import domain.Book;

import java.util.List;

public interface IBookDAO {
	  //���һ���鵽���ݿ���
		public void addBook(Book book);
		//�޸��û�
		public void alterBook(Book book);
		
		//�����û���Ż�ȡ�û���Ϣ����User�������ʽ����
		public Book getBookById(String id);
		
		//�����û�����ȡ�û���Ϣ����User���󷵻�
		public List<Book> getBookByBookName(String bookName);
		
		//�ж��Ƿ��Ѿ��ϴ����鱾��
		public boolean isUpAllBooks();
		
		//���������
		public List<Book> getAllBooks();
}
