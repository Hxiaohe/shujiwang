package dao;

import domain.Command;

import java.util.List;

public interface ICommandDAO {
	//���һ���û������ݿ���
		public void addCommand(Command command);
		//�޸��û�
		public void alterCommand(Command command);
		
		//�����û���Ż�ȡ�û���Ϣ����User�������ʽ����
		public Command getCommandById(String id);
		
		//�����û�����ȡ�û���Ϣ����User���󷵻�
		public List<Command> getUserByUserName(String userName);
		
		//�����������
		public List<Command> getAllCommands();
}
