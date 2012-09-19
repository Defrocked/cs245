package playlists;

import java.util.*;


public class Playlist implements Comparable<Song> {

	private String name;
	private List<Song> songs;

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

	@Override
	public int compareTo(Song o) {
		boolean result;
		int tmp;
		int t = 1;

		tmp = (songs.indexOf(o));
		result = (songs.get(tmp).equals(o));
		if (result = true){
			t = 0;
		}
		return t;
	}

	public boolean contains(Song o) {
		return songs.contains(o);
	}

	public void sortBySong() {
		Comparable.sort(songs);

	}

}
