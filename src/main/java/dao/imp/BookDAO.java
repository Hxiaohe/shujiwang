package dao.imp;

import dao.IBookDAO;
import domain.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO {

	@Override
	public void addBook(Book book) {
		Connection conn = new dao.imp.DatabaseDAO().getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into book(bookname,author,chaodai,zishu,lujing) " +
					"values('"+book.getBookname()+"','"+book.getAuthor()+"','"
					+book.getChaodai()+"','"+book.getZishu()+"','"+book.getLujing()+"')";
			
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
	public void alterBook(Book book) {
		Connection conn = new dao.imp.DatabaseDAO().getConnection();
		Statement pstmt = null;
		
		try {
			String sql = "update book set bookname='"+book.getBookname()+"', author='"
		+book.getAuthor()+"', chaodai='"+book.getChaodai()+"', zishu="+book.getZishu()+", lujing='"+book.getLujing()+"'";
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
	public Book getBookById(String id) {
		Connection conn = new dao.imp.DatabaseDAO().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book =new Book();
		try {
			String sql = "select * from book where id='"+id+"'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				book.setId(rs.getString("id"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setChaodai(rs.getString("chaodai"));
				book.setZishu(Integer.parseInt(rs.getString("zishu")));
				book.setLujing(rs.getString("lujing"));
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
		return book;
	}

	@Override
	public List<Book> getBookByBookName(String bookName) {
		Connection conn = new dao.imp.DatabaseDAO().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book =new Book();
		List<Book> list = new ArrayList<Book>();
		try {
			String sql = "select * from book where bookname='"+bookName+"'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				book.setId(rs.getString("id"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setChaodai(rs.getString("chaodai"));
				book.setZishu(Integer.parseInt(rs.getString("zishu")));
				book.setLujing(rs.getString("lujing"));
				list.add(book);
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
		return list;
	}

	@Override
	public boolean isUpAllBooks() {
		Connection conn = new dao.imp.DatabaseDAO().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from book ";
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
		return true;
	}

	@Override
	public List<Book> getAllBooks() {
		Connection conn = new dao.imp.DatabaseDAO().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book =new Book();
		List<Book> list = new ArrayList<Book>();
		try {
			String sql = "select * from book ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				book.setId(rs.getString("id"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setChaodai(rs.getString("chaodai"));
				book.setZishu(Integer.parseInt(rs.getString("zishu")));
				book.setLujing(rs.getString("lujing"));
				list.add(book);
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
		return list;
	}

}
