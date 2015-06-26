package day2;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMessage {
	
	protected static Logger logger = Logger.getLogger(TestMessage.class.getName());
	
	@Test
	public void messageTest() {
		String[] config = {"applicationContext.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		String msg = context.getMessage("login.success", new Object[]{"admin"}, Locale.ENGLISH);
		logger.debug(msg);
		Assert.assertNotNull(msg);
	}
}
