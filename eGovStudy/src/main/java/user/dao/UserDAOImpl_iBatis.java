package user.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import user.vo.UserVO;

import com.ibatis.sqlmap.client.SqlMapClient;

@Component("ibatis")
public class UserDAOImpl_iBatis implements UserDAO{
	
	protected static Logger logger = Logger.getLogger(UserDAOImpl_iBatis.class.getName());

	@Autowired
	SqlMapClient mapClient;
	
	@Override
	public UserVO login(String id, String pw) {
		logger.debug("UserDAOImpl_iBatis DB 연동");
		UserVO vo = new UserVO();
		vo.setUserid(id);
		vo.setUserpwd(pw);
		try {
			vo = (UserVO) mapClient.queryForObject("login", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int addUser(UserVO user) {
		int row = 0;
		try {
			row = mapClient.update("add", user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public UserVO getUser(String uid) {
		UserVO vo = null;
		try {
			vo = (UserVO) mapClient.queryForObject("getuser",uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<UserVO> getUserList() {
		List<UserVO> list = new ArrayList<UserVO>();
		System.out.println(" UserDAOImpl_iBatis : "+mapClient);
		try {
			list =mapClient.queryForList("list");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public HashMap<String, UserVO> list(){
		HashMap<String, UserVO> map = new HashMap<String, UserVO>();
		try {
			map = 
			(HashMap<String,UserVO>) mapClient.queryForMap("list",null,"userid");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public int updateUser(UserVO user) {
		int row = 0;
		try {
			row = mapClient.update("update", user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteUser(String uid) {
		int row = 0;
		try {
			row = mapClient.delete("delete", uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
}














