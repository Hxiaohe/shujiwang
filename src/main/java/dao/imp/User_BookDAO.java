package dao.imp;

import dao.IUSer_BookDAO;
import domain.Command;
import domain.User_Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User_BookDAO implements IUSer_BookDAO {

	@Override
	public void addUser_Book(User_Book user_Book) {

		Connection conn = new dao.imp.DatabaseDAO().getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into book_user(bookId,userId) " +
					"values('"+user_Book.getBookId()+"','"+user_Book.getUserId()+"')";

			pstmt = conn.prepareStatement(sql);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void alterUser_Book(User_Book user_Book) {


		Connection conn = new dao.imp.DatabaseDAO().getConnection();
		Statement pstmt = null;

		try {
			String sql = "delete from book_user where bookId='"
					+user_Book.getBookId()+"' and userId='"+user_Book.getUserId()+"'";
			pstmt = conn.createStatement();
			pstmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public User_Book getUser_BookById(String id) {
		// TODO Auto-generated method stub
        return null;
	}

	@Override
	public List<domain.User_Book> getUser_BookByUserId(String userId) {

        Connection conn = new DatabaseDAO().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<User_Book> user_books = new ArrayList<User_Book>();
        try {
            String sql = "select * from book_user where userId='"+userId+"'";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                User_Book user_book=new User_Book();
                user_book.setId(rs.getString("Id"));
                user_book.setBookId(rs.getString("bookId"));
                user_book.setUserId(rs.getString("userId"));
                user_books.add(user_book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
                pstmt.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user_books;
	}

	@Override
	public List<domain.User_Book> getAllUser_Books() {
        Connection conn = new DatabaseDAO().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<User_Book> user_books = new ArrayList<User_Book>();
        try {
            String sql = "select * from book_user";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                User_Book user_book=new User_Book();
                user_book.setId(rs.getString("Id"));
                user_book.setBookId(rs.getString("bookId"));
                user_book.setUserId(rs.getString("userId"));
                user_books.add(user_book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
                pstmt.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user_books;
	}

    @Override
    public boolean isUser_Book(String userId, String bookId) {

        Connection conn = new dao.imp.DatabaseDAO().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from book_user where bookId= '"+bookId+"'AND userId='"+userId+"'";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
                pstmt.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
