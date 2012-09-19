package playlists;

public class Song implements Comparable<Song> {

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

		return ((this.title.equals(s.title)) && (this.artist.equals(s.artist)) && (this.runningTime == s.runningTime));
	}

	public int compareTo(Song o) {
		int tmp;
		tmp = compareTitle(o);
		
		System.out.println("stage1");
		if (tmp == 0) {
			System.out.println("stage2");
			tmp = ( o.runningTime - this.runningTime);	
			
			
			if (tmp != 0) {
				
				System.out.println("stage3");
				tmp = o.artist.compareTo(o);
				
			}
		}
		return tmp;
	}
	
	private int compareTitle(Song o){
		String sub1 = this.title.substring(0,1);
		String sub2 = o.title.substring(0,1);
		String array = "abcdefghijklmnopqrstuvwxyz1234567890";
		int temp = 	array.indexOf(sub1);
		int t = array.indexOf(sub2);
		return temp - t;
	}
}
