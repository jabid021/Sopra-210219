package demoAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTest {

	@Pointcut("execution(* *.*.display(..))")
	public void pointcut() {

	}

	@Before("pointcut()")
	public void before(JoinPoint jointPoint) {
		System.out.println("before");
		System.out.println(jointPoint);
		if (jointPoint.getTarget() instanceof Personne) {
			System.out.println("c'est une personne");
			((Personne) jointPoint.getTarget()).methodeExecuteDansLeBeforeDeLAspect();
		}
	}

	@After("pointcut()")
	public void after() {
		System.out.println("after");
	}

	@AfterReturning(pointcut = "pointcut()", returning = "retour")
	public void afterReturning(String retour) {
		System.out.println("after returning:" + retour);
	}

	@AfterThrowing(pointcut = "pointcut()")
	public void afterThrowing() {
		System.out.println("after throw");
	}

	@Around("pointcut()")
	public void around(ProceedingJoinPoint pJP) throws Throwable {
		System.out.println("avant l'execution");
		pJP.proceed();
		System.out.println("apres l'execution");
	}

}
