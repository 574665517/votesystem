package vip.itellyou.dao;

import vip.itellyou.util.base.BaseDao;

/**
 * �û����ݷ�������ӽӿڣ��̳�BaseDao
 * @author ywx
 *
 */
public interface SubjectDao extends BaseDao{
    //�̳У���ͨ�õ�CRUD����
	//�����Ӧ�ı�������������ݲ���Ҫ��
	//�������������Ĵ�����
	
	public int getGenerateId() throws Exception;
	public int getUserCount(int subjectId) throws Exception;
}
