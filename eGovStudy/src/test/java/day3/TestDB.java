package day3;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.UserService;
import user.vo.UserVO;

public class TestDB {
	
	protected static Logger logger = Logger.getLogger(TestDB.class.getName());
	
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
	
	@Test
	public void addUserTest() {
		UserVO vo = new UserVO();
		vo.setUserid("aircha");
		vo.setUsername("어차");
		vo.setUserpwd("1234");
		vo.setEmail("aircha@samsungsds.com");
		vo.setPhone("010-0909-0909");
		vo.setAddress("남양주");
		int row = service.addUser(vo);
		logger.debug("addUserTest UserVO : "+vo.toString());
		Assert.assertTrue(row > 0);
	}
	
	@Test
	public void getUserTest() {
		UserVO vo = service.getUser("aircha");
		logger.debug(vo);
		Assert.assertNotNull("getUserTest UserVO : "+vo.toString());
	}
	
	@Test
	public void getUserListTest() {
		List<UserVO> list = service.getUserList();
		for (UserVO tempVo : list) {
			logger.debug("getUserListTest List<UserVO> : "+tempVo.toString());
		}
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void updateUserTest() {
		UserVO vo = new UserVO();
		vo.setUserid("aircha");
		vo.setEmail("aircha@samsungsds.com");
		vo.setPhone("010-400-1231");
		vo.setAddress("유나이티드남양주");
		int row = service.updateUser(vo);
		logger.debug("updateUserTest row : "+row);
		Assert.assertTrue(row > 0);
	}
	
	@Test
	public void deleteUserTest() {
		int row = service.deleteUser("aircha");
		logger.debug("deleteUserTest row : "+row);
		Assert.assertTrue(row > 0);
	}
}
