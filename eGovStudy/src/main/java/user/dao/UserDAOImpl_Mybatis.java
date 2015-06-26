package user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import user.vo.UserVO;

@Component("mybatis")
public class UserDAOImpl_Mybatis implements UserDAO{
    
	@Autowired
	SqlSession session;
	
	@Override
	public UserVO login(String id, String pw) {
		System.out.println("UserDAOImpl_Mybatis DB 연동");
		UserVO vo = new UserVO();
		vo.setUserid(id);
		vo.setUserpwd(pw);
		vo = session.selectOne("user.login", vo);
		return vo;
	}
	@Override
	public int addUser(UserVO user) {
		return session.insert("user.add", user);
		
	}
	@Override
	public UserVO getUser(String uid) {
		return session.selectOne("user.getuser",uid);
	}
	@Override
	public List<UserVO> getUserList() {
		return session.getMapper(mapper.UserMapper.class).list();
	}
	@Override
	public int updateUser(UserVO user) {
		return session.update("user.update", user);
	}
	@Override
	public int deleteUser(String uid) {
		return session.delete("user.delete", uid);
	}
	public List<UserVO> searchUser(String condition,String keyword){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(condition, keyword);
		map.put("userid", "ad");
		return session.selectList("user.searchuser", map);
	}
}

















