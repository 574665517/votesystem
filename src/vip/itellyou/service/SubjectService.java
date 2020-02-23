package vip.itellyou.service;

import java.util.List;

import vip.itellyou.pojo.Subject;
import vip.itellyou.pojo.User;

/**
 * �û�ҵ���߼��ӿ�
 * @author ywx
 *
 */
public interface SubjectService {
	//���������Ŀ
	public void add(Subject subject,User user) throws Exception;
	public List<Subject> getSubjects() throws Exception;
	public Subject getSubject(int id) throws Exception;
	public void modify(Subject subject, User attribute) throws Exception;
}
