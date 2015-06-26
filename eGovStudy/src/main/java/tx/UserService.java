package tx;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import user.dao.UserDAO;
import user.vo.UserVO;

@Service("txservice")
public class UserService {
	
	protected static Logger logger = Logger.getLogger(UserService.class.getName());
	
	@Resource(name="mybatis")
	UserDAO dao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int adduser(UserVO user, boolean flag) {
		int row;
		row = dao.addUser(user);
		logger.info(user.getUserid() + " insert ok.");
		
		if (flag)
			throw new RuntimeException("사용자 등록 중 문제발생");
		
		user.setUserid(user.getUserid()+"*");
		row += dao.addUser(user);
		logger.info(user.getUserid() + " insert ok");
		return row;
	}
	
	public void print() {
		logger.info("====== User List ======");
		for (UserVO data : dao.getUserList())
			logger.info(data.toString());
	}
}
