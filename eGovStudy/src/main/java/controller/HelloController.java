package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		System.out.println(3/0);
		mav.addObject("data", "Welcome!!");
		mav.setViewName("hello");
		return mav;
	}
}
