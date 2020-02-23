/**
 *  @author ywx
 *  @ date 2018��12��11��
 */
package vip.itellyou.util.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ںͳ�����֮��ĸ�ʽת��
 * @author ywx
 * @ date 2018��12��11��
 */
public class DateFormatter {
	//������ת��������
	public static String toShortDate(Long time) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy��MM��dd��");
		return df.format(new Date(time));
	}
	
	//���ڸ�ʽת���ɳ�����
	public static Long toLong(String date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.parse(date).getTime();
	}

}
