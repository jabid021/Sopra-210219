package exoAspect.musique;

import org.springframework.stereotype.Component;

import exoAspect.annotation.LesSpectateurs;

@Component
public class Comique {
	@LesSpectateurs
	public void faireSonShow() {
		System.out.println("le comique fait son show");
	}
}
