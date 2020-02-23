package vip.itellyou.util.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vip.itellyou.util.dao.DbHelper;

/**
 * 数据访问的父类，实现父接口中的增删改查的方法
 * 
 * @author ywx
 *
 */
public abstract class BaseDaoImpl implements BaseDao {

	@Override
	public int insert(Object data) throws Exception {
		// JDBC
		// 1 创建数据库连接对象Connection
		Connection con = DbHelper.getConnection();
		// 2 编写sql语句，创建命令对象PreparedStatement
		String sql = getInsertSql(data);
		PreparedStatement pst = con.prepareStatement(sql);

		// 3 执行命令：executeUpdate ,executeQuery
		int rows = pst.executeUpdate();

		// 4 处理执行的结果：ResultSet结果集
		// 结果集中的记录转换成实体类对象
		// 5 释放资源(关闭连接)
		DbHelper.closeAll(null, pst, null);
		return rows;
	}

	@Override
	public int update(Object data) throws Exception {
		// 1 创建数据库连接对象Connection
		Connection con = DbHelper.getConnection();
		// 2 编写sql语句，创建命令对象PreparedStatement
		String sql = getUpdateSql(data);
		PreparedStatement pst = con.prepareStatement(sql);

		// 3 执行命令：executeUpdate ,executeQuery
		int rows = pst.executeUpdate();

		// 4 处理执行的结果：ResultSet结果集
		// 结果集中的记录转换成实体类对象
		// 5 释放资源(关闭连接)
		DbHelper.closeAll(null, pst, null);
		return rows;
	}

	@Override
	public int delete(int id) throws Exception {
		// 1 创建数据库连接对象Connection
		Connection con = DbHelper.getConnection();
		// 2 编写sql语句，创建命令对象PreparedStatement
		String sql = getDeleteSql(id);
		PreparedStatement pst = con.prepareStatement(sql);

		// 3 执行命令：executeUpdate ,executeQuery
		int rows = pst.executeUpdate();

		// 4 处理执行的结果：ResultSet结果集
		// 结果集中的记录转换成实体类对象
		// 5 释放资源(关闭连接)
		DbHelper.closeAll(null, pst, null);
		return rows;
	}

	public List<Object> findAll() throws Exception {
		// 1 创建数据库连接对象Connection
		Connection con = DbHelper.getConnection();
		// 2 编写sql语句，创建命令对象PreparedStatement
		String sql = getFindAllSql();
		PreparedStatement pst = con.prepareStatement(sql);

		// 3 执行命令：executeUpdate ,executeQuery
		ResultSet rs = pst.executeQuery();
		// 4 处理执行的结果：ResultSet结果集
		// 结果集中的记录转换成实体类对象
		List<Object> list = new ArrayList<Object>();
		// 按照结果集中的数据进行循环
		while (rs.next()) {
			// 将一条记录转换成java对象
			Object data = rsToObject(rs);
			// 将对象加入到集合中
			list.add(data);
		}

		// 5 释放资源(关闭连接)
		DbHelper.closeAll(null, pst, rs);

		return list;
	}

	// 根据id主键查一个对象
	public Object getModel(int id) throws Exception {
		// 1 创建数据库连接对象Connection
		Connection con = DbHelper.getConnection();
		// 2 编写sql语句，创建命令对象PreparedStatement
		String sql = getFindAllSql() + " where id = "+id;
		PreparedStatement pst = con.prepareStatement(sql);

		// 3 执行命令：executeUpdate ,executeQuery
		ResultSet rs = pst.executeQuery();
		// 4 处理执行的结果：ResultSet结果集
		// 结果集中的记录转换成实体类对象
		Object result = null;
		// 按照结果集中的数据进行循环
		if (rs.next()) {
			// 将一条记录转换成java对象
			result = rsToObject(rs);
		}

		// 5 释放资源(关闭连接)
		DbHelper.closeAll(null, pst, rs);

		return result;
	}

	// 按照条件来查所有满足条件的记录
	// 构造条件的数据：一般是属于某些属性的值；实体类
	// UserQueryModel SubjectQueryModel

	public List<Object> findByCondition(BaseQueryModel queryModel) throws Exception {
		// 1 创建数据库连接对象Connection
		Connection con = DbHelper.getConnection();
		// 2 编写sql语句，创建命令对象PreparedStatement
		String sql = getFindConditionSql(queryModel);
		PreparedStatement pst = con.prepareStatement(sql);

		// 3 执行命令：executeUpdate ,executeQuery
		ResultSet rs = pst.executeQuery();
		// 4 处理执行的结果：ResultSet结果集
		// 结果集中的记录转换成实体类对象
		List<Object> list = new ArrayList<Object>();
		while (rs.next()) {
			// 将一条记录转换成java对象
			Object data = rsToObject(rs);
			// 将对象加入到集合中
			list.add(data);
		}

		// 5 释放资源(关闭连接)
		DbHelper.closeAll(null, pst, rs);

		return list;
	}
	
	//获取最后新增的记录的id
		public Long findMaxId() throws Exception {
			// 1 创建Connection对象
			Connection con = DbHelper.getConnection();
			// 2 编写SQL语句，创建PreparedStatement对象
			String sql = "SELECT LAST_INSERT_ID() AS maxid";
			PreparedStatement pst = con.prepareStatement(sql);
			// 3 执行命令:executeUpdate,executeQuery
			// 返回值就是结果集
			ResultSet rs = pst.executeQuery();
			// 4 处理执行的结果(ResultSet中的记录=>java对象)
			Long result = null;
			// 对结果集进行循环，每循环一次读取一条记录
			if (rs.next()) {
				result = rs.getLong("maxid");
			}
			// 5 释放资源
			DbHelper.closeAll(null, pst, null);

			return result;
		}

	// 产生sql语句的抽象方法，留给子类实现
	public abstract String getInsertSql(Object data);
    public abstract String getUpdateSql(Object data);
    public abstract String getDeleteSql(int id);
	public abstract String getFindAllSql();

	public abstract String getFindConditionSql(BaseQueryModel queryModel);

	// 将结果集中的一条记录转换成一个Java对象
	public abstract Object rsToObject(ResultSet rs) throws Exception;

}