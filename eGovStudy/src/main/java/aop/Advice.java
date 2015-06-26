package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class Advice {
	
@Pointcut("execution(* user.service.*Service.login(..))")
	public void pc(){}
	
    @Around("aop.Advice.pc()")
	public Object alog(ProceedingJoinPoint jp) 
			                         throws Throwable{
		System.out.println("=========== start ========");
        Object obj =  jp.proceed(); 
        
		System.out.println("=========== end ========");
		return obj;
	}
	
	@AfterThrowing(pointcut="pc()",throwing="e")
	public void log(JoinPoint jp , Exception e){
		System.out.println("******** log AOP ***********");
		System.out.println(jp.getSignature().getName());
		System.out.println("Exception :  "+e.getMessage());
		System.out.println("***************************");
	}
	
	//@AfterReturning(pointcut="pc()",returning="obj")
    public void elog(Object obj){
    	System.out.println("********** AOP log ********* ");
    	System.out.println("Advice : "+obj);
		System.out.println("***************************");
    }
}
