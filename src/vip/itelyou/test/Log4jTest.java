package vip.itelyou.test;

import org.apache.logging.log4j.*;
import org.junit.*;


/**
 * @author ywx
 * @ date 2018年12月6日
 */
public class Log4jTest {
	private Logger logger = LogManager.getLogger("Log4jTest");
	
	@Test
	public void testC3p0() {
		logger.info("这是一个log4j的info日志");
	}
}
