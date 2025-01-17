package vip.itellyou.dao.impl;

import java.sql.ResultSet;

import vip.itellyou.dao.UserDao;
import vip.itellyou.pojo.User;
import vip.itellyou.pojo.UserQueryModel;
import vip.itellyou.util.base.BaseDaoImpl;
import vip.itellyou.util.base.BaseQueryModel;

/**
 * 数据访问的子类：用户
 * 用户数据访问类：继承BaseDaoImpl父类，实现UserDao子接口
 * 子类实现抽象方法，产生SQL语句
 * @author ywx
 *
 */

public class UserDaoImpl extends BaseDaoImpl implements UserDao{

	@Override
	public String getInsertSql(Object data) {
		//向下转型
		User user = (User)data;
		return "insert into t_user(name,pwd,online) " +
	    " values('"+user.getName()+"','"+user.getPwd()+"',"+user.getOnline()+")";
	}

	@Override
	public String getFindAllSql() {		
		return "select * from t_user";
	}

	//构建一个带条件的sql语句
	//BaseQueryModel queryModel记录了条件的值
	@Override
	public String getFindConditionSql(BaseQueryModel queryModel) {
		//向下转型
		UserQueryModel qm = (UserQueryModel)queryModel;
		StringBuilder sb = new StringBuilder();
		sb.append("select * from t_user");
		sb.append(" where 1 = 1 ");
		if(qm.getName() != null && qm.getName().trim().length()>0){
			sb.append(" and name = '" + qm.getName()+"'");
		}
		if(qm.getPwd() != null && qm.getPwd().trim().length()>0){
			sb.append(" and pwd = '" + qm.getPwd()+"'");
		}
		if(qm.getOnline() > 0){
			sb.append("and online = " + qm.getOnline());
		}
		return sb.toString();
	}

	@Override
	public Object rsToObject(ResultSet rs) throws Exception {
		//1 创建User实体类对象
		User user = new User();
		//2 从ResultSet结果集中读取一条记录，将每个字段的值
		//复制给User对象的对应属性
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setPwd(rs.getString("pwd"));
		user.setOnline(rs.getInt("online"));
		
		return user;
	}

	@Override
	public String getUpdateSql(Object data) {
		User user = (User)data;
		return "update t_user set name = '" + user.getName() + "',pwd = '" + user.getPwd()+"',"+
	    "online=" + user.getOnline() + " where id =" + user.getId();
	}

	@Override
	public String getDeleteSql(int id) {
		return "delete from t_user where id = " + id;
	}

	@Override
	public Integer findId() throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Object getModel(int id) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}
   
}

