package exoAspect.musique;

import org.springframework.stereotype.Component;

import exoAspect.annotation.LesSpectateurs;

@Component
public class Pianiste implements Musicien {

	@Override
	@LesSpectateurs
	public void jouer() {
		 System.out.println("le pianiste joue");

		
	}

}
