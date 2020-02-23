package vip.itellyou.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vip.itellyou.util.format.DateFormatter;

/**
 * ������Ŀ����ʵ����
 * 
 * > ����ֶεĴ�������һ����������
 * @author ywx
 * @ date 2018��12��8��
 */
public class Subject {
	
	public static final int SINGLE = 1;
	public static final int MULTI = 2;
	//ʹ�ó���������ҳ������Ҫ��ʾ���Ǽ���ֵ
	public static final String SINGLE_NAME = "��ѡ";
	public static final String MULTI_NAME = "��ѡ";
	
	//ʹ��map��ֵ�Լ��������峣������ʾֵ֮��Ĺ�ϵ
		public static Map<Integer,String> numberMap 
		     = new HashMap<Integer,String>();
		static {
			numberMap.put(SINGLE,SINGLE_NAME);
			numberMap.put(MULTI, MULTI_NAME);
		}
		
	private Integer id;//������
	private String title;//�����ı���
	private int number;//ͶƱ����1��ʾ��ѡ 2��ʾ��ѡ
	private Long startTime;
	private Long endTime;
	
	//����һ����������(���)
	//�෽������ά����д����"һ��"�Ķ���
	private User user;//������
	//������ѡ��
	private List<Option> options;
	private int optionCount;
	
	//������ͼֵ
	private String startTimeView;
	private String endTimeView;
	private String numberView;
	private int userCount;;

	public String getNumberView() {
		return numberView;
	}
	public void setNumberView(String numberView) {
		this.numberView = numberView;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
		//����Ӧ����ͼ���Ը�ֵ		
		this.startTimeView = DateFormatter.toShortDate(this.startTime);
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
		this.endTimeView = DateFormatter.toShortDate(this.endTime);
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStartTimeView() {
		return startTimeView;
	}
	public String getEndTimeView() {
		return endTimeView;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
		this.setOptionCount(options.size());
	}
	public Subject() {
		super();
		this.user = new User();
		this.options = new ArrayList<Option>();
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	public int getOptionCount() {
		return optionCount;
	}
	public void setOptionCount(int optionCount) {
		this.optionCount = optionCount;
	}
}
