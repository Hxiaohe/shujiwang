package dao;

import domain.User_Book;

import java.util.List;

public interface IUSer_BookDAO {
		 void addUser_Book(User_Book user_Book);

		 void alterUser_Book(User_Book user_Book);

		 User_Book getUser_BookById(String id);

		 List<User_Book> getUser_BookByUserId(String userId);

		 List<User_Book> getAllUser_Books();

		 boolean isUser_Book(String userId,String bookId);
		
}
