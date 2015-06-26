package day2;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.UserService;
import user.vo.UserVO;


public class TestDAO {
	
	protected static Logger logger = Logger.getLogger(TestDAO.class.getName());
	
	ApplicationContext context;
	UserService service;
	
	@Before
	public void stringContext() {
		String[] config = {"applicationContext.xml"};
		context = new ClassPathXmlApplicationContext(config);
		service = (UserService) context.getBean("service");
	}
	
	@Test
	public void daoTest() {
		UserService service = (UserService) context.getBean("service");
		UserVO vo = service.login("admin", "a1234");
		logger.debug(vo);
		Assert.assertNotNull(vo.toString());
	}
}
