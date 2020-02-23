package vip.itellyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vip.itellyou.dao.SubjectDao;
import vip.itellyou.pojo.Subject;
import vip.itellyou.pojo.SubjectQueryModel;
import vip.itellyou.util.base.BaseDaoImpl;
import vip.itellyou.util.base.BaseQueryModel;
import vip.itellyou.util.dao.DbHelper;

public class SubjectDaoImpl extends BaseDaoImpl implements SubjectDao {

	@Override
	public String getInsertSql(Object data) {
		Subject subject = (Subject)data;		
		return 
		        "insert into t_subject(title,number,starttime,endTime,userId) values('"+subject.getTitle()+"',"+subject.getNumber()+","+subject.getStartTime()+","+subject.getEndTime()+","+subject.getUser().getId()+")";
	}

	@Override
	public String getFindAllSql() {
		// TODO Auto-generated method stub
		return "select * from t_subject";
	}

	@Override
	public String getFindConditionSql(BaseQueryModel queryModel) {
		SubjectQueryModel qm = (SubjectQueryModel)queryModel;
		StringBuilder sb = new StringBuilder();
		sb.append("select * from t_subject where 1=1 ");
		if(qm.getTitle() != null && qm.getTitle().trim().length()>0){
			sb.append(" and title='"+qm.getTitle()+"' ");
		}
		if(qm.getUser() != null || qm.getUser().getId() != null){
			sb.append(" and userId=" + qm.getUser().getId());
		}
		return sb.toString();
	}

	@Override
	public Object rsToObject(ResultSet rs) throws Exception {
		// 将一个记录转换成一个实体对象
		
		Subject subject  = new Subject();
		//将rs中记录的字段值读取出来
		//赋值给实体类对象的属性
		subject.setId(rs.getInt("id"));
		subject.setTitle(rs.getString("title"));
		subject.setNumber(rs.getInt("number"));
		subject.setStartTime(rs.getLong("startTime"));
		subject.setEndTime(rs.getLong("endTime"));
		subject.getUser().setId(rs.getLong("userId"));
		
		return subject;
	}

	@Override
	public String getUpdateSql(Object data) {
		Subject subject=(Subject)data;
		return "update t_subject set title='"+subject.getTitle()+"',number="+subject.getNumber()+",startTime="+subject.getStartTime()+",endTime="+subject.getEndTime()+" where id="+subject.getId();
	}

	@Override
	public String getDeleteSql(int id) {
		return "delete from t_subject where id=" + id;
	}

	@Override
	public Integer findId() throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int getGenerateId() throws Exception {
		int result = 0;
		Connection con = DbHelper.getConnection();
		String sql = "SELECT max(id) as id from t_subject";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
			result = rs.getInt("id");
		}
		DbHelper.closeAll(null, pst, rs);
		return result;
	}

	@Override
	public int getUserCount(int subjectId) throws Exception {
		int result = 0;
		Connection con = DbHelper.getConnection();
		String sql = "SELECT COUNT(DISTINCT userId) as cnt FROM t_record WHERE subjectId="+subjectId;
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
			result = rs.getInt("cnt");
		}
		DbHelper.closeAll(null, pst, rs);
		return result;
	}

	@Override
	public Object getModel(int id) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

}
