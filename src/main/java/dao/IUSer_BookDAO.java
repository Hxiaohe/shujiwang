package dao;

import domain.User_Book;

import java.util.List;

public interface IUSer_BookDAO {
	//���һ���û������ݿ���
		public void addUser_Book(User_Book user_Book);
		//�޸��û�
		public void alterUser_Book(User_Book user_Book);
		
		//�����û���Ż�ȡ�û���Ϣ����User�������ʽ����
		public User_Book getUser_BookById(String id);
		
		//�����û�����ȡ�û���Ϣ����User���󷵻�
		public List<User_Book> getUserByUser_BookName(String user_BookName);
		
		//huode����
		public List<User_Book> getAllUser_Books();
		
}
