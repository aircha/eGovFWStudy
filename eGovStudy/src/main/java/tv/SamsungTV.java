package tv;

import org.springframework.beans.factory.InitializingBean;

public class SamsungTV implements TV, InitializingBean {

	public SamsungTV() {
		super();
		System.out.println("SamsungTV 객체 생성.");
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV --- 전원을 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV --- 전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		System.out.println("SamsungTV --- 소리를 높인다.");
	}

	@Override
	public void voumeDown() {
		System.out.println("SamsungTV --- 소리를 낮춘다.");
	}
	
	public void init() {
		System.out.println("SamsungTV 초기화...... 수행.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SamsungTV afferPropertiesSet 초기화..... 수행.");
	}

}
