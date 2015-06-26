package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String handllerRequest(HttpServletRequest request, HttpServletResponse response);
}
