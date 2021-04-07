package exoAspect.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import exoAspect.musique.Musicien;
import exoAspect.musique.Pianiste;
import exoAspect.musique.Trompetiste;

@Component
@Aspect
public class Spectateur {

	@Autowired
	@Qualifier("trompetiste")
	private Musicien trompetiste;

	@Pointcut("@annotation(exoAspect.annotation.LesSpectateurs)")
	public void jouer() {

	}

	@Around("jouer()")
	public void arround(ProceedingJoinPoint pJP) throws Throwable {
		if (pJP.getTarget() instanceof Pianiste) {
			prendrePlace();
			try {
				pJP.proceed();
			} finally {
				trompetiste.jouer();
			}
		} else if (pJP.getTarget() instanceof Trompetiste) {
			try {
				pJP.proceed();
			} finally {
				partir();
			}
		}

	}

	public void prendrePlace() {
		System.out.println("le public s'installe");
	}

	@AfterReturning(pointcut = "jouer()")
	public void applaudir() {
		System.out.println("bravo");
	}

	@AfterThrowing(pointcut = "jouer()")
	public void siffler() {
		System.out.println("siffler");
	}

	public void partir() {
		System.out.println("le public part");
	}
}
