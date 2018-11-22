package service.imp;

import dao.IInfoDAO;
import dao.imp.InfoDAO;
import domain.Information;
import service.IInfoService;

import java.util.List;

/**
 * Information���Ӧ��ҵ���߼��� �ṩҵ���߼�����
 */
public class InfoService implements IInfoService {
	/**
	 * ����IInfoDAO���͵����ԣ���ʵ��InfoService��IInfoDAOʵ����֮���Э��
	 */
	private IInfoDAO infoDAO=new InfoDAO();

	/**
	 * Ĭ�Ϲ��캯��
	 */
	public InfoService() {
		
	}

	/**
	 * �����ݿ��������Ϣ
	 */

	@Override
	public void addInfo(Information information) {
		// �����ϢΪ�գ��򷵻أ��������
	if (information.getTitle() == null)
	     return;
		// ��ϢID��Ϊ�գ�˵������Ϣ�����ݿ����Ѵ��ڣ���Ӧ������Ӷ�Ӧ���Ǹ���
		// �����ݿ��������Ϣ
		infoDAO.addInfo(information);
	}

	/**
	 * ������ݿ���������Ϣ������List<Information>����
	 */
	@Override
	public List<Information> getAllInfo() {
		return infoDAO.getAllInfo();
	}

}
