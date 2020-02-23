package vip.itellyou.service.impl;

import java.util.List;

import vip.itellyou.dao.UserDao;
import vip.itellyou.dao.impl.UserDaoImpl;
import vip.itellyou.pojo.User;
import vip.itellyou.pojo.UserQueryModel;
import vip.itellyou.service.UserService;
import vip.itellyou.util.exception.RuleException;
import vip.itellyou.util.format.Md5Class;

/**
 * �����û����ݵ�ҵ���߼���
 * 1>ʵ�ֽӿ�
 * 2>ҵ���߼����������ݷ���
 * @author ywx
 * @ date 2018��12��4��
 */
public class UserServiceImpl implements UserService {
	//�����ݷ��ʽӿ���Ϊ����
	private UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public void register(User user) throws Exception {
		//�û����Ǳ�����д��
		if(user.getName() == null || user.getName().trim().length() == 0) {
			//�׳��쳣���׳��ض����쳣
			throw new RuleException("�û�������Ϊ��");
		}
		//ȷ�����������һ��
		if(!user.getPwd().equals(user.getConfirmPwd())) {
			throw new RuleException("ȷ��������������һ��");
		}
		
		//�û���Ӧ��ҪΨһ
		//������ѯģ�Ͷ��󣬲�������ѯ������ֵ
		UserQueryModel qm = new UserQueryModel();
		qm.setName(user.getName());
		//��ѯ
		List list = userDao.findByCondition(qm);
		//�ж�
		if(list.size() > 0) {
			throw new RuleException("�û����Ѿ���ע��");
		}
		
		//����Ҫ���ܣ���������״̬Ϊ1
		user.setOnline(1);
        user.setPwd(Md5Class.stringToMd5(user.getPwd()));
		
		userDao.insert(user);
				
	}

	@Override
	public User login(User user) throws Exception {
		//��ɵ�¼
				//1 �����û�����������ɲ�ѯ
				UserQueryModel qm = new UserQueryModel();
				qm.setName(user.getName());
				qm.setPwd(Md5Class.stringToMd5(user.getPwd()));
				
				List list = userDao.findByCondition(qm);
				if(list.size()==1){
					//�и��û�
					user = (User)list.get(0);
					if(user.getOnline()==User.ONLINE){
						throw new RuleException("���û��Ѿ���¼");
					}
					
					//��¼�Ѿ��ɹ����޸�����״̬
					user.setOnline(User.ONLINE);
					userDao.update(user);
				}
				else{
					throw new RuleException("�û������ڻ����������");
				}
				
				return user;
			}

	@Override
	public User getUser(int id) throws Exception {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void online(User user, boolean inOrOut) {
		// TODO �Զ����ɵķ������
		
	}

}
