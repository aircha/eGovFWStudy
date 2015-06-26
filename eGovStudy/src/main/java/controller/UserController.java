package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import user.service.UserService;
import user.vo.UserVO;
import validator.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/user/list.do")
	public ModelAndView getUserList() {
		ModelAndView mav = new ModelAndView();
		List<UserVO> list = service.getUserList();
		mav.addObject("users", list);
		mav.setViewName("user/user_list");
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/user/add.do")
	public String getUserForm() {
		return "user/user_form";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/user/add.do")
	public String userProc(@ModelAttribute("user") UserVO user, BindingResult errors) {
		new UserValidator().validate(user, errors);
		
		if (errors.hasFieldErrors())
			return "user/user_form";
		
		service.addUser(user);
		return "redirect:/user/list.do";
	}
	
	@RequestMapping("/user/view.do")
	public ModelAndView userView(String userid) {
		ModelAndView mav = new ModelAndView();
		UserVO vo = service.getUser(userid);
		mav.addObject("user", vo);
		mav.setViewName("user/user_view");
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/user/modify.do")
	public ModelAndView userModify(String userid) {
		ModelAndView mav = new ModelAndView();
		UserVO vo = service.getUser(userid);
		mav.addObject("user", vo);
		mav.setViewName("user/user_modify");
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/user/update.do")
	public String userUpdate(UserVO user) {
		service.updateUser(user);
		return "redirect:/user/view.do?userid="+user.getUserid();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/user/remove.do")
	public String userDelete(String userid) {
		service.deleteUser(userid);
		return "redirect:/user/list.do";
	}
	
	@ExceptionHandler(Exception.class)
	public String handllerException(Exception exception) {
		return "error";
	}
}
