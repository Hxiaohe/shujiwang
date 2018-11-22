package dao;

import domain.Information;

import java.util.List;


public interface IInfoDAO {
	
	
	
	//�÷���ʵ�����һ����Ϣ�����ݿ���
	public void addInfo(Information info); 
	
	//�÷�����ȡ���е���Ϣ��
	public List<Information> getAllInfo();
	
	
}
