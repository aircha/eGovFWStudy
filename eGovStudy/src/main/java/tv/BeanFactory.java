package tv;

public class BeanFactory {
	
	public Object getBean(String beanName) {
		if (beanName.equals("s")) {
			return new SamsungTV();
		} else if (beanName.equals("l")) {
			return new LgTV();
		}
		return null;
	}
}
