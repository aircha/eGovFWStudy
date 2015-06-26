package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Aspect
public class TimeCheckAdvice {

	@Pointcut("execution(* user.service.UserService.login(..))")
	public void userPointcut(){}
	
	@Around("execution(* user.service.UserService.login(..))")
	public Object timeCheck(ProceedingJoinPoint pjp) throws Throwable{
		Object obj = null;
		String method = pjp.getSignature().getName();
		long start = System.currentTimeMillis();
		
		obj = pjp.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println(method + "() 메소드 수행에 걸린 시간 : "
				+ (end - start) + "ms(초)");
		return obj;
	}
	
	
	
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger("egovframework");

	@AfterThrowing(pointcut="userPointcut()",throwing="e")
	public void ex( JoinPoint jp,Exception e){
		LOGGER.error("AOP : "+jp.getSignature().getName() +" : "+ e.getMessage());
	}
}





