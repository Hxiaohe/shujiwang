package dao;


import domain.User;

import java.util.List;


public interface IUserDAO {
	
	//���һ���û������ݿ���
	public void addUser(User user);
	//�޸��û�
	public void alterUser(User user);
	
	//�����û���Ż�ȡ�û���Ϣ����User�������ʽ����
	public User getUserById(String id);
	
	//�����û�����ȡ�û���Ϣ����User���󷵻�
	public List<User> getUserByUserName(String userName);
	
}
