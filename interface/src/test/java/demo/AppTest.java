package demo;

public class AppTest {
	public static void main(String[] args) {
		Musicien unMusicien = MusicienFactory.getMusicien();
		unMusicien.jouer();
	}
}
