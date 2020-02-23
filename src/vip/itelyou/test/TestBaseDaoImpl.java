package vip.itelyou.test;

import org.junit.Assert;
import org.junit.Test;

import vip.itellyou.dao.impl.UserDaoImpl;
import vip.itellyou.pojo.User;
import vip.itellyou.util.base.BaseDaoImpl;

/**
 * @author ywx
 * @ date 2018��11��29��
 */
public class TestBaseDaoImpl {
	//���Է���
	//ע��
	@Test
	public void testInsert() throws Exception {
		//����Ŀ����Ķ���
		BaseDaoImpl baseDao = new UserDaoImpl(); 
			//���ö����Ŀ�귽����Ϊ�˵õ�ʵ�����еĽ��
		User user = new User();
		user.setName("�ŷ�");
		user.setPwd("123456");
		user.setOnline(1);
		
		int actual = baseDao.insert(user);
		//д����Ԥ�ƽ�������˹����ݹ���Ԥ�Ƴ����Ľ����
		int expected = 1;
		//ʹ�ö�����ķ������Ƚ�ʵ�����еĽ����Ԥ�ƵĽ��
		Assert.assertEquals(expected, actual);
	}

}
