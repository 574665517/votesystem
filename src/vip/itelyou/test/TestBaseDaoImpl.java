package vip.itelyou.test;

import org.junit.Assert;
import org.junit.Test;

import vip.itellyou.dao.impl.UserDaoImpl;
import vip.itellyou.pojo.User;
import vip.itellyou.util.base.BaseDaoImpl;

/**
 * @author ywx
 * @ date 2018年11月29日
 */
public class TestBaseDaoImpl {
	//测试方法
	//注解
	@Test
	public void testInsert() throws Exception {
		//创建目标类的对象
		BaseDaoImpl baseDao = new UserDaoImpl(); 
			//调用对象的目标方法，为了得到实际运行的结果
		User user = new User();
		user.setName("张飞");
		user.setPwd("123456");
		user.setOnline(1);
		
		int actual = baseDao.insert(user);
		//写下来预计结果（是人工根据功能预计出来的结果）
		int expected = 1;
		//使用断言类的方法来比较实际运行的结果和预计的结果
		Assert.assertEquals(expected, actual);
	}

}
