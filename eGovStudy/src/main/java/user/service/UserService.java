package user.service;

import java.util.List;

import user.vo.UserVO;

public interface UserService {
   public UserVO login(String id , String pw);
   public int addUser(UserVO user);
   public UserVO getUser(String uid);
   public List<UserVO> getUserList();
   public int updateUser(UserVO user);
   public int deleteUser(String uid);

}
