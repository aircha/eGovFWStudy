package servlet;

import java.util.HashMap;

public class HandllerMapping {
	HashMap<String, Controller> map = new HashMap<String, Controller>();
	
	public HandllerMapping() {
		map.put("/list.do", new ListController());
		map.put("/login.do", new LoginController());
	}
	
	public Controller getMap(String key) {
		return map.get(key);
	}
}
