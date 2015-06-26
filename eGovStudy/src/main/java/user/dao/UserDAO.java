package user.dao;

import java.util.List;

import user.vo.UserVO;

public interface UserDAO {
	   public UserVO login(String id, String pw);
	   public int addUser(UserVO user);
	   public UserVO getUser(String uid);
	   public List<UserVO> getUserList();
	   public int updateUser(UserVO user);
	   public int deleteUser(String uid);
}
