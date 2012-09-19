package playlists;

import java.util.*;

public class Lab2 {

	
	public static void main(String[] args) {

		// Create some artists
		ArrayList<Artist> aList = new ArrayList<Artist>();
		Artist a1 = new Artist("Stevenson", "Dan");
		Artist a2 = new Artist("Morrison", "Mike");
		Artist a3 = new Artist("Morrison", "Jolene");
		aList.add(a1);
		aList.add(a2);
		aList.add(a3);
		
		
		// Create some songs and attach them to the artists
		Song s1 = new Song("foo", a1, 200);
		a1.addSong(s1);
		
		Song s2 = new Song("bar", a1, 300);
		a1.addSong(s2);
		
		Song s3 = new Song("foo", a2, 200);
		a2.addSong(s3);
		
		Song s4 = new Song("foo", a3, 200);
		a3.addSong(s4);
		
		Song s5 = new Song("foo", a1, 100);
		a1.addSong(s5);
		
		// Create a playlist
		Playlist pl1 = new Playlist("MyPlaylist");
		pl1.addSong(s1);
		pl1.addSong(s2);
		pl1.addSong(s3);
		pl1.addSong(s4);
		pl1.addSong(s5);

		// Display the original playlist
		System.out.println(pl1);
		
		// Ask some questions
		System.out.println(pl1.contains(s2));
		System.out.println(pl1.contains(new Song("foo", a1, 200)));
		System.out.println(pl1.contains(new Song("foo", new Artist("Morrison", "Mike"), 200)));
		
		System.out.println(pl1.runningTime());

		// Sort the playlist and display the result
		pl1.sortBySong();
		System.out.println(pl1);
	}

}
