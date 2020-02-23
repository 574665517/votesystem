package vip.itellyou.service;

import java.util.List;

import vip.itellyou.pojo.Subject;
import vip.itellyou.pojo.User;

/**
 * 用户业务逻辑接口
 * @author ywx
 *
 */
public interface SubjectService {
	//发起调查项目
	public void add(Subject subject,User user) throws Exception;
	public List<Subject> getSubjects() throws Exception;
	public Subject getSubject(int id) throws Exception;
	public void modify(Subject subject, User attribute) throws Exception;
}
