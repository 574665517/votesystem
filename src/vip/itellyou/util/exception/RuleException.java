/**
 *  @author ywx
 *  @ date 2018��12��4��
 */
package vip.itellyou.util.exception;

/**
 * Υ��ҵ���߼����쳣��
 * ԭ��һ�����û��Ĳ������������£�һ��Ҫ�������ݻ���
 * @author ywx
 * @ date 2018��12��4��
 */
public class RuleException extends RuntimeException {//�﷨�������
	//1
	//2�ڹ��췽���и����쳣��ԭ��
	public RuleException(String message) {
		super(message);
	}
}
