package exoAspect.musique;

import org.springframework.stereotype.Component;

import exoAspect.annotation.LesSpectateurs;


public class Trompetiste implements Musicien {

	@Override
	@LesSpectateurs
	public void jouer() {
		System.out.println("le trompetiste joue");
		throw new IllegalArgumentException();

	}

}
