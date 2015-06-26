package day2;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.UserService;
import user.vo.UserVO;

public class TestMain {
	
	protected static Logger logger = Logger.getLogger(TestMain.class.getName());

	public static void main(String[] args) {
		String[] config = {"applicationContext.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		UserService service = (UserService) context.getBean("service");
		UserVO vo = service.login("admin", "a1234");
		logger.debug(vo);
	}

}
