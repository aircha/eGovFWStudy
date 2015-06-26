package user.service;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import user.dao.UserDAO;
import user.vo.UserVO;

@Service("service")
public class UserServiceImpl implements UserService{
    
	//@Autowired
	//@Qualifier("ibatis")
	@Resource(name="mybatis")
	private UserDAO dao ; 
    
	@Autowired
	ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) {
		
		this.applicationContext = applicationContext;
	}
	
	public UserServiceImpl() {	}
	public UserServiceImpl(UserDAO dao) {
		this.dao = dao;
	}
	public UserDAO getDao() {
		return dao;
	}
	
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	@Override
	public UserVO login(String id, String pw) {
		UserVO vo = dao.login(id, pw);
		if(vo != null){
			System.out.println(applicationContext.
					           getMessage("login.success", 
					        	   new Object[]{id},
					        	   Locale.getDefault()));
		}else{
			System.out.println(applicationContext.
			           getMessage("login.failed", 
			        	   new Object[]{id},
			        	   Locale.getDefault()));
		}
		return vo;
	}

	@Override
	public int addUser(UserVO user) {
		return dao.addUser(user);
	}

	@Override
	public UserVO getUser(String uid) {
		return dao.getUser(uid);
	}

	@Override
	public List<UserVO> getUserList() {
		return dao.getUserList();
	}

	@Override
	public int updateUser(UserVO user) {
		return dao.updateUser(user);
	}

	@Override
	public int deleteUser(String uid) {
		return dao.deleteUser(uid);
	}
}







