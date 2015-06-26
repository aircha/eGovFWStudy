package tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.vo.UserVO;

public class TestMain {

	public static void main(String[] args) {
		String[] config = {"applicationContext.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		UserService service = (UserService) context.getBean("txservice");
		UserVO user = new UserVO();
		user.setUserid("thin");
		user.setUsername("환형");
		user.setUserpwd("dlsxoghks");
		user.setEmail("thin@datastreams.co.kr");
		user.setAddress("금호성 화제노래방");
		user.setPhone("010-1234-1234");
		service.adduser(user, true);
		service.print();
	}

}
