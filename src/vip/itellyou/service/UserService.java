/**
 *  @author ywx
 *  @ date 2018��12��4��
 */
package vip.itellyou.service;

import vip.itellyou.pojo.User;

/**
 * �û�ҵ���߼��ӿ�
 * @author ywx
 * @ date 2018��12��4��
 */
public interface UserService {
	//����ע��ķ���
	public void register(User user) throws Exception;

	//�����¼�õ��û���������
		//��ѯ
		public User login(User user) throws Exception;
		public User getUser(int id) throws Exception;
		public void online(User user,boolean inOrOut);
}
