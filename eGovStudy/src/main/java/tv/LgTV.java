package tv;

public class LgTV implements TV {

	public LgTV() {
		super();
		System.out.println("LgTV 객체 생성.");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV --- 전원을 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV --- 전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		System.out.println("LgTV --- 소리를 높인다.");
	}

	@Override
	public void voumeDown() {
		System.out.println("LgTV --- 소리를 낮춘다.");
	}

}
