package vip.itelyou.test;

import org.apache.logging.log4j.*;
import org.junit.*;


/**
 * @author ywx
 * @ date 2018��12��6��
 */
public class Log4jTest {
	private Logger logger = LogManager.getLogger("Log4jTest");
	
	@Test
	public void testC3p0() {
		logger.info("����һ��log4j��info��־");
	}
}
