package dao.imp;

import java.sql.*;

public class DatabaseDAO {
	 private Connection conn = null;
     /**
     * ��ȡ���ݿ����Ӷ���
     * @return ���ݿ����Ӷ���
     * @throws ClassNotFoundException
     * @throws SQLException
     */
	 public Connection getConnection()  {	
		 Connection conn = null;
         //�������ݿ�����
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/guji", "root", "h520520...");
			  	}catch(Exception e){
				e.printStackTrace();
			}

			  	System.out.println("���ݿ����ӳɹ���");
			return conn;
	}
     /**
	  * �ر����е����Ӷ���
	  * @throws SQLException
	  */
	 public void releaseConnection()
			throws SQLException {
		this.conn.close();
		this.conn = null;
	}
	/**
	 * ִ��һ��SQL��ѯ��䣬�����ز�ѯ�Ľ����
	 * @param
	 * @return ���ݿ��ѯ�����
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ResultSet getResultSet(String querySQL) throws SQLException, ClassNotFoundException
	{
		System.out.println("sql���"+querySQL);
		if(conn == null)
		{
			this.conn = getConnection();
		}
		Statement stm = conn.createStatement();

        //ִ��SQL��ѯ��䲢���ز�ѯ�����
		ResultSet thisRST = stm.executeQuery(querySQL);
		return thisRST;
	}
    /**
	 * ֱ��ִ��һ�������ݿ��޸ģ�������ɾ�ģ���SQL���
	 * @param
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void executeSQL(String SQL) throws SQLException,
 ClassNotFoundException
	{
		if(conn == null)
		{
			this.conn = getConnection();
		}
		Statement stm = conn.createStatement();

		//ִ�и�����SQL���
		stm.executeUpdate(SQL);

        //�ر����Ӷ���
		this.conn.close();
		this.conn = null;
	}

}

