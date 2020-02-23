package vip.itellyou.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vip.itellyou.util.format.DateFormatter;

/**
 * 调查项目主题实体类
 * 
 * > 外键字段的处理，定义一个导航属性
 * @author ywx
 * @ date 2018年12月8日
 */
public class Subject {
	
	public static final int SINGLE = 1;
	public static final int MULTI = 2;
	//使用常量来定义页面上需要显示的那几个值
	public static final String SINGLE_NAME = "单选";
	public static final String MULTI_NAME = "多选";
	
	//使用map键值对集合来定义常量和显示值之间的关系
		public static Map<Integer,String> numberMap 
		     = new HashMap<Integer,String>();
		static {
			numberMap.put(SINGLE,SINGLE_NAME);
			numberMap.put(MULTI, MULTI_NAME);
		}
		
	private Integer id;//主题编号
	private String title;//主键的标题
	private int number;//投票类型1表示单选 2表示多选
	private Long startTime;
	private Long endTime;
	
	//定义一个导航属性(外键)
	//多方来进行维护，写的是"一方"的对象
	private User user;//发起人
	//导航：选项
	private List<Option> options;
	private int optionCount;
	
	//定义视图值
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
		//给对应的视图属性赋值		
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
