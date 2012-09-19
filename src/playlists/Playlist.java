package playlists;

import java.util.*;


public class Playlist {

	private String name;
	private ArrayList<Song> songs;

	public Playlist(String name) {
		this.name = name;
		this.songs = new ArrayList<Song>();
	}

	public String toString() {
		String temp = "MyPlaylist [";
		for (int i = 0; i < songs.size(); i++) {
			temp = temp + Song.toString(songs.get(i)) + ", ";
		}
		temp = temp.substring(0, temp.length() - 2);
		temp = temp + "]";
		return temp;
	}

	public boolean equals(Object o) {
		Playlist p = (Playlist) o;

		return ((this.name == p.name) && (this.songs == p.songs));
	}

	public void addSong(Song s) {
		songs.add(s);
	}

	public int runningTime() {
		int temp = 0;
		for (int i = 0; i < songs.size(); i++) {
			temp = temp + Song.getRunTime(songs.get(i));
		}
		return temp;
	}
	
	public int compareTo(Song o) {
		int temp;
		int tmp;

		tmp = (songs.indexOf(o));
		temp = (Song.getRunTime(songs.get(tmp)) - Song.getRunTime(o));
		
		return temp;
	}
	
	

	public boolean contains(Song o) {
		return songs.contains(o);
	}

	public void sortBySong() {
		Collections.sort(songs);

	}

}
