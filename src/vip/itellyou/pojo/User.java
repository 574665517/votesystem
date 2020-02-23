package vip.itellyou.pojo;

/**
 * 用户实体类
 * 1> 一个字段=>属性
 * 2> 给每个属性提供getter和setter访问器
 * 3> 考虑重载构造方法(一定要保留默认的构造方法)
 * 
 * 4> 视图属性，视图值：提供属性记录视图有关的数据
 * 5> 定义一些常用的常量值
 * @author ywx
 *
 */
public class User {
	
	public static final int OFFLINE = 1;
	public static final int ONLINE = 2;
	public static final String SESSION_NAME = "CurrentUser";
	
	//null代表id中没有值
	private Long id;
	private String name;
	private String pwd;
	//1 不在线，2 在线
	private int online;
	
	//“一方”维护，定义多方对象
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
