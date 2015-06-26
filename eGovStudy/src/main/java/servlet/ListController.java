package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDAO;
import user.dao.UserDAOImpl_JDBC;
import user.service.UserService;
import user.service.UserServiceImpl;
import user.vo.UserVO;

public class ListController implements Controller {

	@Override
	public String handllerRequest(HttpServletRequest request, HttpServletResponse response) {
		UserDAO dao = new UserDAOImpl_JDBC();
	    UserService service = new UserServiceImpl(dao);
	    List<UserVO> list = service.getUserList();
	    request.setAttribute("users", list);
		return "/list.jsp";
	}

}
