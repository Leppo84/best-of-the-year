package first.spring.classes;

public class Movie {

	private int id;
	private String title;
	
	public Movie(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
