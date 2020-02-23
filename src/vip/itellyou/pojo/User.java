package vip.itellyou.pojo;

/**
 * �û�ʵ����
 * 1> һ���ֶ�=>����
 * 2> ��ÿ�������ṩgetter��setter������
 * 3> �������ع��췽��(һ��Ҫ����Ĭ�ϵĹ��췽��)
 * 
 * 4> ��ͼ���ԣ���ͼֵ���ṩ���Լ�¼��ͼ�йص�����
 * 5> ����һЩ���õĳ���ֵ
 * @author ywx
 *
 */
public class User {
	
	public static final int OFFLINE = 1;
	public static final int ONLINE = 2;
	public static final String SESSION_NAME = "CurrentUser";
	
	//null����id��û��ֵ
	private Long id;
	private String name;
	private String pwd;
	//1 �����ߣ�2 ����
	private int online;
	
	//��һ����ά��������෽����
	//private List<Subject> subjects;
	
	private String confirmPwd;
	
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public Long getId() {
		return id;
	}
	public void setId(long l) {
		this.id = l;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
	
	
}
