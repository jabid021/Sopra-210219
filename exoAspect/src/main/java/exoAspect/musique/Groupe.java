package exoAspect.musique;

import exoAspect.annotation.LesSpectateurs;

public class Groupe implements Musicien {

	@Override
	@LesSpectateurs
	public void jouer() {
		System.out.println("jouer du groupe");
	}

}
