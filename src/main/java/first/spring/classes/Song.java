package first.spring.classes;

public class Song {
	
	private int id;
	private String title;
	private String artist;
	
	public Song(int id, String title, String artist) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
	}
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	
	
}
