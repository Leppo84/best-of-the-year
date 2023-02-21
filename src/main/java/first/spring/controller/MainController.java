package first.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import first.spring.classes.Movie;
import first.spring.classes.Song;

@Controller
@RequestMapping("/")
public class MainController {
	
	@GetMapping()
	public String home(Model model) {
		model.addAttribute("myName", "Leppo");
		return "index";
	}
	
	@GetMapping("/error")
	public String error() {
		return "/error";
	}
	
	private List<Movie> getBestMovies() {
		List<Movie> bestMovies = new ArrayList<>();
		bestMovies.add(new Movie(1, "The Fifth Element", "L. Besson"));
		bestMovies.add(new Movie(2, "The Hateful Eights", "Q. Tarantino"));
		bestMovies.add(new Movie(3, "Eyes Wide Shut", "S. Kubrik"));
		return bestMovies;
	}
	
	@GetMapping("/movies")
	public String getMovies (Model m) {
		List<Movie> bestMovies = getBestMovies();
//		List<String> movieTitles = bestMovies.stream().map(Movie::getTitle).collect(Collectors.toList());
		m.addAttribute ("movies", bestMovies );
		return "movies";
	}
	
	@GetMapping("/movies/{id}")
	public String movieDetail (@PathVariable("id") String id, Model md) {
		List<Movie> bestMovies = getBestMovies();
		getBestMovies();
		md.addAttribute ("movie", bestMovies.get(Integer.parseInt(id)-1));
//		return bestMovies.get(id-1);
		return "/movieDetail";
	}

	private List<Song> getBestSongs() {
		List<Song> bestSongs = new ArrayList<>();
		bestSongs.add(new Song(1, "Sandman", "Metallica"));
		bestSongs.add(new Song(2, "Child in Time", "Deep Purple"));
		bestSongs.add(new Song(3, "What a wonderfull world", "L. Armstrong"));
		return bestSongs;
	}
	
	@GetMapping("/songs")
	public String getSongs (Model s) {
		List<Song> bestSongs = getBestSongs();
		s.addAttribute ("songs", bestSongs );
		return "songs";
	}
	
	@GetMapping("/songs/{id}")
	public String songDetail (@PathVariable("id") String id, Model sd) {
		List<Song> bestSongs = getBestSongs();
		getBestSongs();
		sd.addAttribute ("song", bestSongs.get(Integer.parseInt(id)-1));
		return "/songDetail";
	}
	
}
