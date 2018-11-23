package service.imp;

import dao.IUSer_BookDAO;
import dao.imp.User_BookDAO;
import domain.User_Book;
import service.IUser_BookService;

import java.util.List;

public class User_BookService implements IUser_BookService {
    private IUSer_BookDAO user_bookDAO=new User_BookDAO();
    @Override
    public void addUser_Book(User_Book user_Book) {
        user_bookDAO.addUser_Book(user_Book);
    }

    @Override
    public void alterUser_Book(User_Book user_Book) {
        user_bookDAO.alterUser_Book(user_Book);
    }

    @Override
    public User_Book getUser_BookById(String id) {
        return user_bookDAO.getUser_BookById(id);
    }

    @Override
    public List<User_Book> getUser_BookByUserId(String userid) {
        return user_bookDAO.getUser_BookByUserId(userid);
    }

    @Override
    public List<User_Book> getAllUser_Books() {
        return user_bookDAO.getAllUser_Books();
    }

    @Override
    public boolean isUser_Book(String userId, String bookId) {
        return user_bookDAO.isUser_Book(userId,bookId);
    }
}
