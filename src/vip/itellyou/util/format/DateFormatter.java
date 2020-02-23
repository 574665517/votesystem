/**
 *  @author ywx
 *  @ date 2018年12月11日
 */
package vip.itellyou.util.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期和长整型之间的格式转换
 * @author ywx
 * @ date 2018年12月11日
 */
public class DateFormatter {
	//长整型转换到日期
	public static String toShortDate(Long time) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		return df.format(new Date(time));
	}
	
	//日期格式转换成长整型
	public static Long toLong(String date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.parse(date).getTime();
	}

}
