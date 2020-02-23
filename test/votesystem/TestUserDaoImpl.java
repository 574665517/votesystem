package votesystem;

import org.junit.Test;

import junit.framework.Assert;
import vip.itellyou.dao.impl.UserDaoImpl;
import vip.itellyou.pojo.User;

public class TestUserDaoImpl {
	@Test
	public void testInsert() throws Exception{
		// ����Ŀ����Ķ��󣬵���Ŀ�귽�����õ�ʵ�����еĽ��
		UserDaoImpl userDao = new UserDaoImpl();
		
		User user = new User();
		user.setName("Rose");
		user.setPwd("123456");
		user.setOnline(1);
		
		int actual = userDao.insert(user);
		
		// д���� Ԥ�ƵĽ��
		int expected = 1;
		// ʹ�ö�����Ƚ�Ԥ�ƵĽ����ʵ�����еĽ��
		Assert.assertEquals(expected, actual);
	}
}