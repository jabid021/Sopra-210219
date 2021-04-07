package exoAspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonAspect {
	@Pointcut("execution(* exoAspect.dao.DaoGeneric.insert(..))")
	public void pointcutInsert() {

	}

	@Pointcut("execution(* exoAspect.dao.DaoGeneric.findByKey(..))")
	public void pointcutFindByKey() {

	}

	@Before("pointcutInsert()")
	public void logBeforeInsert() {
		System.out.println("lancement insert");
	}

	@Before("pointcutFindByKey()")
	public void logBeforeFindByKey() {
		System.out.println("lancement find");
	}

	@After("pointcutInsert()")
	public void logAfterInsert() {
		System.out.println("fin insert");
	}

	@After("pointcutFindByKey()")
	public void logAfterFind() {
		System.out.println("fin find");
	}

	@Before("@annotation(exoAspect.annotation.Log)")
	public void beforeAvecAnnotation(JoinPoint jp) {
		if (jp.getSignature().getName().equals("insert")) {
			System.out.println("on execute un insert");
		} else {
			System.out.println("on execute le find");
		}
	}
}
