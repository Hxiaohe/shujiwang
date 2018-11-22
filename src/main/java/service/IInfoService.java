package service;

import domain.Information;

import java.util.List;

/**
 * Information��Ӧ��ҵ���߼��ӿڣ��ṩһЩ����Ϣ��ص�ҵ���߼������Ĺ����ķ�������
 */
public interface IInfoService {
	
	//���һ��������Ϣ�����ݿ�
	public void addInfo(Information information);

	//��ȡ������Ϣ�б�
	public List<Information> getAllInfo();
}
