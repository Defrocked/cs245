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
		
		return ((this.lastName.equals(a.lastName)) &&
				(this.firstName.equals(a.firstName)));
	}
	
	public void addSong(Song s){
		songs.add(s);
	}
	
	public int compareTo(Song o) {
		int t = 0;
		int temp = 0;
		int tmp = 0;
		String sub1 = "";
		String sub2 = "";
		sub2 = o.toString();
		Scanner in = new Scanner(sub2);
		in.useDelimiter(" ");
		sub2 = in.next();
		sub1 = this.lastName.substring(0, 1);
		sub2 = sub2.substring(0, 1);
		sub1.toLowerCase();
		sub2.toLowerCase();
		String array = "abcdefghijklmnopqrstuvwxyz1234567890";
		temp = array.indexOf(sub1);
		tmp = array.indexOf(sub2);
		t = temp - tmp;
		in.close();
		return t;
	}
	
}
