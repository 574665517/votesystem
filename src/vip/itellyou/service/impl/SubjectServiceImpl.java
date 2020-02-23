package vip.itellyou.service.impl;

import java.util.Date;
import java.util.List;

import vip.itellyou.dao.OptionDao;
import vip.itellyou.dao.SubjectDao;
import vip.itellyou.dao.impl.OptionDaoImpl;
import vip.itellyou.dao.impl.SubjectDaoImpl;
import vip.itellyou.pojo.Option;
import vip.itellyou.pojo.OptionQueryModel;
import vip.itellyou.pojo.Subject;
import vip.itellyou.pojo.User;
import vip.itellyou.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {
	private SubjectDao subjectDao;
	private OptionDao optionDao;
	
	public SubjectServiceImpl(){
		this.subjectDao = new SubjectDaoImpl();
		this.optionDao = new OptionDaoImpl();
	}
	
	@Override
	public void add(Subject subject,User user) throws Exception {//�ѷ������û�������
		//1 ��������
		//��������Ŀ�ʼͶƱʱ��ͽ���ͶƱʱ��
		Long now = new Date().getTime();
		subject.setStartTime(now);//��ǰʱ������ʼʱ��
		subject.setEndTime(now + 1*24*60*60*1000);//Ĭ������һ��
		//���÷�����
		subject.setUser(user);
		
		subjectDao.insert(subject);
		subject.setId(subjectDao.findId());
		//2 �м���ѡ�����������ѡ��
		int i = 1;
        for(Option option : subject.getOptions()){
        	//������ź������������id
        	option.setId(i++);
        	option.setSubjectId(subject.getId());
        	
        	optionDao.insert(option);
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> getSubjects() throws Exception {
		List list = subjectDao.findAll();
		if(list != null && list.size()>0){
			for(Object data:list){
				Subject subject = (Subject)data;
				OptionQueryModel queryModel = new OptionQueryModel();
				queryModel.setSubjectId(subject.getId());
				subject.setOptions(optionDao.findByCondition(queryModel));
				subject.setUserCount(subjectDao.getUserCount(subject.getId()));
			}
		}
		return list;
	}

	@Override
	public Subject getSubject(int id) throws Exception {
		Subject subject = (Subject)subjectDao.getModel(id);
		if(subject != null){			
			OptionQueryModel queryModel = new OptionQueryModel();
			queryModel.setSubjectId(subject.getId());
			subject.setOptions(optionDao.findByCondition(queryModel));
			subject.setUserCount(subjectDao.getUserCount(subject.getId()));
		}
		return subject;
	}

	@Override
	public void modify(Subject subject, User attribute) throws Exception {
		//�Ѿ�����ͶƱ��¼������������޸�
				if(subjectDao.getUserCount(subject.getId())>0){
					throw new Exception("�Ѿ�����ͶƱ��¼���������޸�");
				}
				//��ʼ�޸�
				subjectDao.update(subject);
				optionDao.deleteOptions(subject.getId());
				for(int i=0;i<subject.getOptions().size();i++){
					Option op = (Option)subject.getOptions().get(i);
					op.setIndex(i+1);
					op.setSubjectId(subject.getId());
					optionDao.insert(op);
				}
	}

}
