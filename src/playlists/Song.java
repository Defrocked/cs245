package playlists;

public class Song {

	private String title;
	private Artist artist;
	private int runningTime; // in sec

	public Song(String title, Artist artist, int runningTime) {
		this.title = title;
		this.artist = artist;
		this.runningTime = runningTime;
	}

	public static String toString(Song s) {
		return s.title + " (" + s.runningTime + ")" + " by " + s.artist;
	}

	public static int getRunTime(Song s) {
		return s.runningTime;
	}

	public boolean equals(Object o) {
		Song s = (Song) o;

		return ((this.title == s.title) && (this.artist == s.artist) && (this.runningTime == s.runningTime));
	}

	public int compareTo(Song o) {
		boolean result;
		int t = 1;

		result = (this.title.equals(o));
		if (result = true) {
			t = 0;
		}
		return t;
	}
}
