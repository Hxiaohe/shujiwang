package service.imp;

import dao.IUserDAO;
import dao.imp.UserDAO;
import domain.User;
import service.IUserService;

import java.util.List;

/**
 * �û������࣬��������ҵ���߼�
 */
public class UserService implements IUserService {
	/**
	 * ����IUserDAO���͵����ԣ���ʵ��UserService��IUserDAOʵ����֮���Э��
	 */
	private IUserDAO userDAO = new UserDAO();

	/**
	 * Ĭ�Ϲ��캯��
	 */
	public UserService() {
		
	}

	
	public void alterUser(User user) {
	
			userDAO.alterUser(user);
	}
	/**
	 * �����ݿ�������û� ����û��������ڣ�����ӣ��������
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		// ����û�Ϊ�գ��򷵻أ��������
		if (user.getUserName() == null)
			return;
	
		// ����û���
		String userName = user.getUserName();
		// �����ݿ��в�ѯ�û���ΪuserName���û�
		List<User> users = userDAO.getUserByUserName(userName);
		// ������ص��û���¼��ĿС�ڵ���0��˵�����û���������
		if (users.size() <= 0) {
			// �����ݿ�������û�
			userDAO.addUser(user);
		} else {
			// �׳��쳣
			throw new RuntimeException("���û����Ѵ��ڣ�������û�����");
		}
	}

	/**
	 * ���ݲ���id��ѯ���ݿ����û�
	 * 
	 * @param id
	 * @return ���ز�ѯ�����û�
	 */
	public User getUserByID(String id) {
		// ���idΪ�գ��򷵻�
		if (id == null)
			return null;
		return userDAO.getUserById(id);
	}

    /**
     * ��֤�û��ĺϷ���
     * 
     * @param ������
     * @return �û��Ϸ�����true�����򷵻�false
     */
	public User validateUser(String userName, String password) {

		//�������ݷ��ʷ�����ȡ�û�����Ӧ���û���Ϣ
		List<User> users = userDAO.getUserByUserName(userName);
		if (users != null && users.size() != 0) {
			if (users.get(0).getPassWord().equals(password)) {
				//����û���������Ϸ����򷵻��û���������Ϣ�����򷵻�null
				return users.get(0);
			}
			else
			{
				return null;
			}
		}
		else	
		{
			return null;
		}
	}
    
	/**
	 * ��֤�û����Ƿ��Ѿ�����
	 * 
	 * @param
	 * @return �����򷵻�true�����򷵻�false
	 */
	public boolean isUserExist(String userName) {
		List<User> users = userDAO.getUserByUserName(userName);
		if(users.size()!=0)
			return true;
		else
			return false;
	}
}
