package dao;

import domain.Command;

import java.util.List;

public interface ICommandDAO {
	//���һ��������ݿ���
		 void addCommand(Command command);
		//�޸�����
		 void alterCommand(Command command);
		
		//���������Ż�ȡ������Ϣ����Command�������ʽ����
		 Command getCommandById(String id);
		
		//�����û�����ȡ������Ϣ����Command���󷵻�
		 List<Command> getCommandsByUserId(String userId);


	//�����û�����ȡ������Ϣ����Command���󷵻�
	 List<Command> getCommandsByBookId(String bookId);
		
		//�����������
		 List<Command> getAllCommands();

		 //ĳ�û��Ƿ�����ĳ��
		 boolean isBybookIdAndUserId(String bookId,String userId);

    //�����û������鼮�����ΨһCommand
    Command getCommandBybookIdAndUserId(String bookId,String userId);
}
