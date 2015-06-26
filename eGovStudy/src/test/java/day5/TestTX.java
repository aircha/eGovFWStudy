package day5;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import tx.UserService;
import user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager="txManager", defaultRollback=true)
@Transactional
public class TestTX {
	
	protected static Logger logger = Logger.getLogger(TestTX.class.getName());
	
	@Resource(name="txservice")
	private UserService service;
	
	@Test
	public void txTest() {
		UserVO user = new UserVO();
		user.setUserid("thin");
		user.setUsername("환형");
		user.setUserpwd("dlsxoghks");
		user.setEmail("thin@datastreams.co.kr");
		user.setAddress("금호성 화제노래방");
		user.setPhone("010-1234-1234");
		Assert.assertEquals(2, service.adduser(user, false));
		service.print();
	}
}
