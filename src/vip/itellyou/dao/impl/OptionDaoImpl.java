package vip.itellyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vip.itellyou.dao.OptionDao;
import vip.itellyou.pojo.Option;
import vip.itellyou.pojo.OptionQueryModel;
import vip.itellyou.util.base.BaseDaoImpl;
import vip.itellyou.util.base.BaseQueryModel;
import vip.itellyou.util.dao.DbHelper;

public class OptionDaoImpl extends BaseDaoImpl implements OptionDao {

	@Override
	public String getInsertSql(Object data) {
		Option option = (Option)data;
		return "insert into t_option(content,idx,subjectId) values"+
				"('"+option.getContent()+"',"+option.getIndex()+","+option.getSubjectId()+")";
	}

	@Override
	public String getFindAllSql() {
		return "select * from t_option ";
	}

	@Override
	public String getFindConditionSql(BaseQueryModel queryModel) {
		OptionQueryModel qm = (OptionQueryModel)queryModel;
		StringBuilder sb = new StringBuilder();
		sb.append("select * from t_option where 1=1 ");
		if(qm.getSubjectId() != null){
			sb.append(" and subjectId=" + qm.getSubjectId());
		}
		
		return sb.toString();
	}

	@Override
	public Object rsToObject(ResultSet rs) throws Exception {
		Option option = new Option();
		option.setId(rs.getInt("id"));
		option.setContent(rs.getString("content"));
		option.setIndex(rs.getInt("idx"));
		option.setSubjectId(rs.getInt("subjectId"));
		
		return option;
	}

	@Override
	public String getUpdateSql(Object data) {
		Option option = (Option)data;
		return "update t_option set content='"+option.getContent()+"',idx="+option.getIndex()+",subjectId="+option.getSubjectId()+" where id="+option.getId();
	}

	@Override
	public String getDeleteSql(int id) {
		return "delete from t_option where id = "+id;
	}

	@Override
	public Integer findId() throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int deleteOptions(int subjectId) throws Exception {
		Connection con = DbHelper.getConnection();
		String sql = "delete from t_option where subjectId="+subjectId;
		PreparedStatement pst = con.prepareStatement(sql);
		int rows = pst.executeUpdate();
		DbHelper.closeAll(null, pst, null);
		return rows;
	}

	@Override
	public Object getModel(int id) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

}
