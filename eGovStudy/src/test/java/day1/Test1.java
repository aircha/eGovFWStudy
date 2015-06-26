package day1;

import java.util.Calendar;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tv.TV;

public class Test1 {
	
	@Test
	public void beanFactoryTest() {
//		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("===================================");
		TV tv = (TV)factory.getBean("s");
		TV tv2 = (TV)factory.getBean("s");
		
		System.out.println("default scope => singleton ? "+(tv==tv2));
//		tv.powerOn();
//		tv.volumeUp();
//		tv.voumeDown();
//		tv.powerOff();
		
		Calendar calendar = (Calendar)factory.getBean("cal");
	}
}
