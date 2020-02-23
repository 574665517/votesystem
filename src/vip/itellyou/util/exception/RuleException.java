/**
 *  @author ywx
 *  @ date 2018年12月4日
 */
package vip.itellyou.util.exception;

/**
 * 违反业务逻辑的异常，
 * 原因一般是用户的不当操作而导致，一般要进行数据回显
 * @author ywx
 * @ date 2018年12月4日
 */
public class RuleException extends RuntimeException {//语法处理最简单
	//1
	//2在构造方法中给定异常的原因
	public RuleException(String message) {
		super(message);
	}
}
