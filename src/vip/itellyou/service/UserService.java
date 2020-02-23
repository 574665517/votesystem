/**
 *  @author ywx
 *  @ date 2018年12月4日
 */
package vip.itellyou.service;

import vip.itellyou.pojo.User;

/**
 * 用户业务逻辑接口
 * @author ywx
 * @ date 2018年12月4日
 */
public interface UserService {
	//处理注册的方法
	public void register(User user) throws Exception;

	//处理登录用的用户名和密码
		//查询
		public User login(User user) throws Exception;
		public User getUser(int id) throws Exception;
		public void online(User user,boolean inOrOut);
}
