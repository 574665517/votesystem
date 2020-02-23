package vip.itellyou.dao.impl;

import java.sql.ResultSet;

import vip.itellyou.dao.UserDao;
import vip.itellyou.pojo.User;
import vip.itellyou.pojo.UserQueryModel;
import vip.itellyou.util.base.BaseDaoImpl;
import vip.itellyou.util.base.BaseQueryModel;

/**
 * ���ݷ��ʵ����ࣺ�û�
 * �û����ݷ����ࣺ�̳�BaseDaoImpl���࣬ʵ��UserDao�ӽӿ�
 * ����ʵ�ֳ��󷽷�������SQL���
 * @author ywx
 *
 */

public class UserDaoImpl extends BaseDaoImpl implements UserDao{

	@Override
	public String getInsertSql(Object data) {
		//����ת��
		User user = (User)data;
		return "insert into t_user(name,pwd,online) " +
	    " values('"+user.getName()+"','"+user.getPwd()+"',"+user.getOnline()+")";
	}

	@Override
	public String getFindAllSql() {		
		return "select * from t_user";
	}

	//����һ����������sql���
	//BaseQueryModel queryModel��¼��������ֵ
	@Override
	public String getFindConditionSql(BaseQueryModel queryModel) {
		//����ת��
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
		//1 ����Userʵ�������
		User user = new User();
		//2 ��ResultSet������ж�ȡһ����¼����ÿ���ֶε�ֵ
		//���Ƹ�User����Ķ�Ӧ����
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
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public Object getModel(int id) throws Exception {
		// TODO �Զ����ɵķ������
		return null;
	}
   
}

