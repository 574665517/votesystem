package vip.itellyou.dao.impl;

import java.util.List;

import vip.itellyou.util.base.BaseDaoImpl;
import vip.itellyou.util.dao.DbHelper;

/**
 * @author ywx
 * @ date 2018Äê12ÔÂ8ÈÕ
 */
public class RegisterDao {
	
	private BaseDaoImpl reg = null;
	
	public int registerUser(List<Object> params) {
		int flag = 0;
		String sql = "insert into t_user(name, pwd) values (?, ?)";
		try {
			DbHelper.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}
}
