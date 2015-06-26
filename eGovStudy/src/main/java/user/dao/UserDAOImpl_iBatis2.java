package user.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import user.vo.UserVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("ibatis2")
public class UserDAOImpl_iBatis2 extends EgovAbstractDAO implements UserDAO{

	@Override
	public UserVO login(String id, String pw) {
		System.out.println("UserDAOImpl_iBatis2 DB 연동");
		UserVO vo = new UserVO();
		vo.setUserid(id);
		vo.setUserpwd(pw);
		return (UserVO) select("login", vo);
	}

	@Override
	public int addUser(UserVO user) {
		System.out.println("UserDAOImpl_iBatis2 DB 연동");

		return update("add", user);
	}

	@Override
	public UserVO getUser(String uid) {
		System.out.println("UserDAOImpl_iBatis2 DB 연동");

		return (UserVO) select("getuser",uid);
	}

	@Override
	public List<UserVO> getUserList() {
		System.out.println("UserDAOImpl_iBatis2 DB 연동");

		return (List<UserVO>) list("list");
	}
	
	public HashMap<String, UserVO> list(){
		System.out.println("UserDAOImpl_iBatis2 DB 연동");

		return (HashMap<String,UserVO>) map("list",null,"userid");
	}

	@Override
	public int updateUser(UserVO user) {
		System.out.println("UserDAOImpl_iBatis2 DB 연동");

		return update("update", user);
	}

	@Override
	public int deleteUser(String uid) {
		System.out.println("UserDAOImpl_iBatis2 DB 연동");

		return delete("delete", uid);
	}
	
}














