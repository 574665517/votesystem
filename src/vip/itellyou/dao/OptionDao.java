package vip.itellyou.dao;

import vip.itellyou.util.base.BaseDao;

/**
 * �û����ݷ�������ӽӿڣ��̳�BaseDao
 * @author ywx
 *
 */
public interface OptionDao extends BaseDao{
    //�̳У���ͨ�õ�CRUD����
	//�����Ӧ�ı�������������ݲ���Ҫ��
	//��������������Ĵ�������
	
	//��������idɾ�����ڸ������ȫ��ѡ��
		public int deleteOptions(int subjectId) throws Exception;
}