package vip.itellyou.service.impl;

import java.util.List;

import vip.itellyou.dao.UserDao;
import vip.itellyou.dao.impl.UserDaoImpl;
import vip.itellyou.pojo.User;
import vip.itellyou.pojo.UserQueryModel;
import vip.itellyou.service.UserService;
import vip.itellyou.util.exception.RuleException;
import vip.itellyou.util.format.Md5Class;

/**
 * 处理用户数据的业务逻辑类
 * 1>实现接口
 * 2>业务逻辑依赖于数据访问
 * @author ywx
 * @ date 2018年12月4日
 */
public class UserServiceImpl implements UserService {
	//将数据访问接口作为属性
	private UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public void register(User user) throws Exception {
		//用户名是必须填写的
		if(user.getName() == null || user.getName().trim().length() == 0) {
			//抛出异常，抛出特定的异常
			throw new RuleException("用户名不能为空");
		}
		//确认密码和密码一致
		if(!user.getPwd().equals(user.getConfirmPwd())) {
			throw new RuleException("确认密码和密码必须一致");
		}
		
		//用户名应该要唯一
		//创建查询模型对象，并构建查询的条件值
		UserQueryModel qm = new UserQueryModel();
		qm.setName(user.getName());
		//查询
		List list = userDao.findByCondition(qm);
		//判断
		if(list.size() > 0) {
			throw new RuleException("用户名已经被注册");
		}
		
		//密码要加密，出事在线状态为1
		user.setOnline(1);
        user.setPwd(Md5Class.stringToMd5(user.getPwd()));
		
		userDao.insert(user);
				
	}

	@Override
	public User login(User user) throws Exception {
		//完成登录
				//1 根据用户名和密码完成查询
				UserQueryModel qm = new UserQueryModel();
				qm.setName(user.getName());
				qm.setPwd(Md5Class.stringToMd5(user.getPwd()));
				
				List list = userDao.findByCondition(qm);
				if(list.size()==1){
					//有该用户
					user = (User)list.get(0);
					if(user.getOnline()==User.ONLINE){
						throw new RuleException("此用户已经登录");
					}
					
					//登录已经成功，修改在线状态
					user.setOnline(User.ONLINE);
					userDao.update(user);
				}
				else{
					throw new RuleException("用户不存在或者密码错误");
				}
				
				return user;
			}

	@Override
	public User getUser(int id) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void online(User user, boolean inOrOut) {
		// TODO 自动生成的方法存根
		
	}

}
