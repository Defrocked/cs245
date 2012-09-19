package playlists;

import java.util.*;

public class Artist {

	private String lastName;
	private String firstName;
	private List<Song> songs;
	
	public Artist(String lastName, String firstName){
		this.lastName = lastName;
		this.firstName = firstName;
		this.songs = new ArrayList<Song>();
	}
	
	public String toString() {
		return firstName + " " + lastName;		
	}
	
	public boolean equals(Object o) {
		Artist a = (Artist)o;
		
		return ((this.lastName == a.lastName) &&
				(this.firstName == a.firstName) &&
				(this.songs == a.songs));
	}
	
	public void addSong(Song s){
		songs.add(s);
	}
	
	public int compareTo(Song o) {
		boolean result;
		int t = 1;

		result = (this.lastName.equals(o));
		if (result = true) {
			t = 0;
		}
		return t;
	}
	
}
