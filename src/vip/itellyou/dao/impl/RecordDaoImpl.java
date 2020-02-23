package vip.itellyou.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import vip.itellyou.dao.RecordDao;
import vip.itellyou.pojo.*;
import vip.itellyou.util.base.BaseDaoImpl;
import vip.itellyou.util.base.BaseQueryModel;

public class RecordDaoImpl extends BaseDaoImpl implements RecordDao {

	@Override
	public String getFindAllSql() {
		return "select * from t_record";
	}

	@Override
	public String getFindConditionSql(BaseQueryModel queryModel) {
		RecordQueryModel qm = (RecordQueryModel)queryModel;
		StringBuilder sb = new StringBuilder();
		sb.append("select * from t_record where 1=1 ");
		if(qm.getSubject().getId()!=null){
			sb.append(" subjectId="+qm.getSubject().getId());
		}
		
		return sb.toString();
	}

	@Override
	public String getInsertSql(Object data) {
		Record record = (Record)data;
		
		return "insert into t_record(userId,subjectId,optionId) values("+record.getUser().getId()+","+record.getSubject().getId()+","+record.getOption().getId()+")";
	}

	@Override
	public String getUpdateSql(Object data) {
		return null;
	}

	@Override
	public String getDeleteSql(int id) {		
		return null;
	}

	@Override
	public Object rsToObject(ResultSet rs) throws Exception {
		Record record= new Record();
		record.setId(rs.getInt("id"));
		record.getUser().setId(rs.getInt("userId"));
		record.getSubject().setId(rs.getInt("subjectId"));
		record.getOption().setId(rs.getInt("optionId"));
		return record;
	}

	@Override
	public int insert(Object data) throws Exception {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int update(Object data) throws Exception {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int delete(int id) throws Exception {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public List findAll() throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List findByCondition(BaseQueryModel queryModel) throws Exception {
		// TODO 自动生成的方法存根
		return null;
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
