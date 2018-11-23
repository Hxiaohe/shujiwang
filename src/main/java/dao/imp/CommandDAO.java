package dao.imp;

import dao.ICommandDAO;
import domain.Command;
import domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandDAO implements ICommandDAO {


	@Override
	public void addCommand(Command command) {

		Connection conn = new dao.imp.DatabaseDAO().getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into command(content,book_com,user_com) " +
					"values('"+command.getContent()+"','"+command.getBookId()+"','"
					+command.getUserId()+"')";

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
	public void alterCommand(Command command) {

		Connection conn = new dao.imp.DatabaseDAO().getConnection();
		Statement pstmt = null;

		try {
			String sql = "update command set content='"+command.getContent()+"' where book_com='"
					+command.getBookId()+"' and user_com='"+command.getUserId()+"'";
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
	public Command getCommandById(String id) {
		return null;
	}

	@Override
	public List<Command> getCommandsByUserId(String userId) {


        Connection conn = new DatabaseDAO().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Command> commands = new ArrayList<Command>();
        try {
            String sql = "select * from command where user_com='"+userId+"'";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Command command=new Command();
                command.setContent(rs.getString("content"));
                command.setId(rs.getString("Id"));
                command.setUserId(rs.getString("user_com"));
                command.setBookId(rs.getString("book_com"));
                commands.add(command);
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
        return commands;
	}

	@Override
	public List<Command> getCommandsByBookId(String bookId) {


		Connection conn = new DatabaseDAO().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Command> commands = new ArrayList<Command>();
		try {
			String sql = "select * from command where book_com='"+bookId+"'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()){
                Command command=new Command();
			    command.setContent(rs.getString("content"));
				command.setId(rs.getString("Id"));
				command.setUserId(rs.getString("user_com"));
				command.setBookId(rs.getString("book_com"));
				commands.add(command);
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
		return commands;
	}

	@Override
	public List<Command> getAllCommands() {



        Connection conn = new DatabaseDAO().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Command> commands = new ArrayList<Command>();
        try {
            String sql = "select * from command ";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Command command=new Command();
                command.setContent(rs.getString("content"));
                command.setId(rs.getString("Id"));
                command.setUserId(rs.getString("user_com"));
                command.setBookId(rs.getString("book_com"));
                commands.add(command);
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
        return commands;
	}

	@Override
	public boolean isBybookIdAndUserId(String bookId, String userId) {

		Connection conn = new dao.imp.DatabaseDAO().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from command where book_com= '"+bookId+"'AND user_com='"+userId+"'";
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

	@Override
	public Command getCommandBybookIdAndUserId(String bookId, String userId) {
		Connection conn = new DatabaseDAO().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Command command = new Command();
		try {
			String sql = "select * from command where book_com='"+bookId+"' AND user_com='"+userId+"'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){

				command.setId(rs.getString("id"));
				command.setContent(rs.getString("content"));
				command.setBookId(rs.getString("book_com"));
				command.setUserId(rs.getString("user_com"));
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
		return command;
	}
}
