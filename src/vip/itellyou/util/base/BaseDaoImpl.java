package vip.itellyou.util.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vip.itellyou.util.dao.DbHelper;

/**
 * ���ݷ��ʵĸ��࣬ʵ�ָ��ӿ��е���ɾ�Ĳ�ķ���
 * 
 * @author ywx
 *
 */
public abstract class BaseDaoImpl implements BaseDao {

	@Override
	public int insert(Object data) throws Exception {
		// JDBC
		// 1 �������ݿ����Ӷ���Connection
		Connection con = DbHelper.getConnection();
		// 2 ��дsql��䣬�����������PreparedStatement
		String sql = getInsertSql(data);
		PreparedStatement pst = con.prepareStatement(sql);

		// 3 ִ�����executeUpdate ,executeQuery
		int rows = pst.executeUpdate();

		// 4 ����ִ�еĽ����ResultSet�����
		// ������еļ�¼ת����ʵ�������
		// 5 �ͷ���Դ(�ر�����)
		DbHelper.closeAll(null, pst, null);
		return rows;
	}

	@Override
	public int update(Object data) throws Exception {
		// 1 �������ݿ����Ӷ���Connection
		Connection con = DbHelper.getConnection();
		// 2 ��дsql��䣬�����������PreparedStatement
		String sql = getUpdateSql(data);
		PreparedStatement pst = con.prepareStatement(sql);

		// 3 ִ�����executeUpdate ,executeQuery
		int rows = pst.executeUpdate();

		// 4 ����ִ�еĽ����ResultSet�����
		// ������еļ�¼ת����ʵ�������
		// 5 �ͷ���Դ(�ر�����)
		DbHelper.closeAll(null, pst, null);
		return rows;
	}

	@Override
	public int delete(int id) throws Exception {
		// 1 �������ݿ����Ӷ���Connection
		Connection con = DbHelper.getConnection();
		// 2 ��дsql��䣬�����������PreparedStatement
		String sql = getDeleteSql(id);
		PreparedStatement pst = con.prepareStatement(sql);

		// 3 ִ�����executeUpdate ,executeQuery
		int rows = pst.executeUpdate();

		// 4 ����ִ�еĽ����ResultSet�����
		// ������еļ�¼ת����ʵ�������
		// 5 �ͷ���Դ(�ر�����)
		DbHelper.closeAll(null, pst, null);
		return rows;
	}

	public List<Object> findAll() throws Exception {
		// 1 �������ݿ����Ӷ���Connection
		Connection con = DbHelper.getConnection();
		// 2 ��дsql��䣬�����������PreparedStatement
		String sql = getFindAllSql();
		PreparedStatement pst = con.prepareStatement(sql);

		// 3 ִ�����executeUpdate ,executeQuery
		ResultSet rs = pst.executeQuery();
		// 4 ����ִ�еĽ����ResultSet�����
		// ������еļ�¼ת����ʵ�������
		List<Object> list = new ArrayList<Object>();
		// ���ս�����е����ݽ���ѭ��
		while (rs.next()) {
			// ��һ����¼ת����java����
			Object data = rsToObject(rs);
			// ��������뵽������
			list.add(data);
		}

		// 5 �ͷ���Դ(�ر�����)
		DbHelper.closeAll(null, pst, rs);

		return list;
	}

	// ����id������һ������
	public Object getModel(int id) throws Exception {
		// 1 �������ݿ����Ӷ���Connection
		Connection con = DbHelper.getConnection();
		// 2 ��дsql��䣬�����������PreparedStatement
		String sql = getFindAllSql() + " where id = "+id;
		PreparedStatement pst = con.prepareStatement(sql);

		// 3 ִ�����executeUpdate ,executeQuery
		ResultSet rs = pst.executeQuery();
		// 4 ����ִ�еĽ����ResultSet�����
		// ������еļ�¼ת����ʵ�������
		Object result = null;
		// ���ս�����е����ݽ���ѭ��
		if (rs.next()) {
			// ��һ����¼ת����java����
			result = rsToObject(rs);
		}

		// 5 �ͷ���Դ(�ر�����)
		DbHelper.closeAll(null, pst, rs);

		return result;
	}

	// �������������������������ļ�¼
	// �������������ݣ�һ��������ĳЩ���Ե�ֵ��ʵ����
	// UserQueryModel SubjectQueryModel

	public List<Object> findByCondition(BaseQueryModel queryModel) throws Exception {
		// 1 �������ݿ����Ӷ���Connection
		Connection con = DbHelper.getConnection();
		// 2 ��дsql��䣬�����������PreparedStatement
		String sql = getFindConditionSql(queryModel);
		PreparedStatement pst = con.prepareStatement(sql);

		// 3 ִ�����executeUpdate ,executeQuery
		ResultSet rs = pst.executeQuery();
		// 4 ����ִ�еĽ����ResultSet�����
		// ������еļ�¼ת����ʵ�������
		List<Object> list = new ArrayList<Object>();
		while (rs.next()) {
			// ��һ����¼ת����java����
			Object data = rsToObject(rs);
			// ��������뵽������
			list.add(data);
		}

		// 5 �ͷ���Դ(�ر�����)
		DbHelper.closeAll(null, pst, rs);

		return list;
	}
	
	//��ȡ��������ļ�¼��id
		public Long findMaxId() throws Exception {
			// 1 ����Connection����
			Connection con = DbHelper.getConnection();
			// 2 ��дSQL��䣬����PreparedStatement����
			String sql = "SELECT LAST_INSERT_ID() AS maxid";
			PreparedStatement pst = con.prepareStatement(sql);
			// 3 ִ������:executeUpdate,executeQuery
			// ����ֵ���ǽ����
			ResultSet rs = pst.executeQuery();
			// 4 ����ִ�еĽ��(ResultSet�еļ�¼=>java����)
			Long result = null;
			// �Խ��������ѭ����ÿѭ��һ�ζ�ȡһ����¼
			if (rs.next()) {
				result = rs.getLong("maxid");
			}
			// 5 �ͷ���Դ
			DbHelper.closeAll(null, pst, null);

			return result;
		}

	// ����sql���ĳ��󷽷�����������ʵ��
	public abstract String getInsertSql(Object data);
    public abstract String getUpdateSql(Object data);
    public abstract String getDeleteSql(int id);
	public abstract String getFindAllSql();

	public abstract String getFindConditionSql(BaseQueryModel queryModel);

	// ��������е�һ����¼ת����һ��Java����
	public abstract Object rsToObject(ResultSet rs) throws Exception;

}