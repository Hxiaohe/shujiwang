package dao.imp;

import dao.IInfoDAO;
import domain.Information;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Information���Ӧ��DAO 
 */
public class InfoDAO  implements IInfoDAO {
	/**
	 * Ĭ�Ϲ��캯��
	 */
	public InfoDAO() {
		
	}

	/**
	 * �����ݿ��������Ϣ
	 */
	@Override
	public void addInfo(Information information) {
		
		//��ʼ�����ݿ������
		DatabaseDAO myDB = new DatabaseDAO();
		//����SQL���
		String sql = "insert into information"+
"(Title,Content,PublishingTime,PublishingUser,Type) values('"
		+information.getTitle()+"','"+information.getContent()+"','"
		+information.getPublishingtime()+"','"+information.getPublishiuser()+"','"+information.getType()+"')";
		
		System.out.println("sql���  "+sql);
		try
		{
			//ִ��SQL���
			myDB.executeSQL(sql);
		}
		//����SQL���ִ�й����п��ܲ������쳣
		catch(SQLException sqlEx)
		{
			sqlEx.printStackTrace();
		}
		catch(ClassNotFoundException cnfEx)
		{
			cnfEx.printStackTrace();
		}
	}

	/**
	 * �����ݿ��л��������Ϣ
	 */
	@Override
	public List<Information> getAllInfo() {
		
		//��ʼ��sql��ѯ���
		String sql = "select * from information";
		//������ط����������ز�ѯ���
		return getInfoBySqlString(sql);
	}

	
	/**
	 * �÷���ͨ��ִ��һ����ѯ��SQL�������ȡ��ѯ��������Ѳ�ѯ�����װ����Ϣ�б�
	 * 
	 * @param sql
	 * @return 
	 */
	public List<Information> getInfoBySqlString(String sql){
		//��ʼ�����ݿ������
		DatabaseDAO myDB = new DatabaseDAO();
		//������Ϣ�б�Ԥ�����ض���
		List<Information> list = new ArrayList<Information>();
		try{
			//ִ��sql��ѯ��䣬����ȡ��ѯ�����
			ResultSet mySet = myDB.getResultSet(sql);
			while(mySet.next())
			{
				//������Ϣ�����������װ��ѯ����
				Information information = new Information();
				//������Ϣ������Id�ֶ�ֵ
				information.setId(mySet.getInt("Id"));
				//������Ϣ�����ı����ֶ�ֵ
				information.setTitle(mySet.getString("Title"));
				//������Ϣ��������Ϣ�����ֶ�ֵ
				information.setContent(mySet.getString("Content"));
				//������Ϣ�����ķ���ʱ���ֶ�ֵ
				information.setPublishingtime(mySet.getString("PublishingTime"));
				//����һ���û�����󣬸ö�������Ϊ��Ϣ�������û��ֶθ�ֵ
				
				//������Ϣ�������û��ֶ�ֵ
				information.setPublishiuser(mySet.getString("PublishingUser"));
				//������Ϣ��������־�����ֶ�ֵ
				information.setType(mySet.getString("Type"));
				//����Ϣ�������뷵�����ݼ���
				list.add(information);
			}
		}
		//�����쳣
		catch(ClassNotFoundException cnfEx)
		{
			cnfEx.printStackTrace();
		}
		catch(SQLException sqlEx)
		{
			sqlEx.printStackTrace();
		}
		finally
		{
			try
			{
				//�ͷ����ݿ����������ݿ����Ӷ���
				myDB.releaseConnection();
			}
			catch(SQLException sqlEx)
			{
				sqlEx.printStackTrace();
			}	
		}
		//���ؽ��
		return list;
	}
}
