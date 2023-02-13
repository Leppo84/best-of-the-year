package first.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	private List<Movie> getBestMovies() {
		List<Movie> bestMovies = new ArrayList<>();
		bestMovies.add(new Movie(1, "Il quinto elemento"));
		bestMovies.add(new Movie(2, "The hatefull eights"));
		bestMovies.add(new Movie(3, "Eyes wide shut"));
		return bestMovies;
	}
	
	@GetMapping("/movies")
	public String getMovies (Model m) {
		List<Movie> bestMovies = getBestMovies();
		List<String> movieTitles = bestMovies.stream().map(Movie::getTitle).collect(Collectors.toList());
		m.addAttribute ("movies", String.join(", ",movieTitles));
		return "movies";
	}

	private List<Song> getBestSongs() {
		List<Song> bestSongs = new ArrayList<>();
		bestSongs.add(new Song(1, "Sandman"));
		bestSongs.add(new Song(2, "Child in Time"));
		bestSongs.add(new Song(3, "What a wonderfull world"));
		return bestSongs;
	}
	
	@GetMapping("/songs")
	public String getSongs (Model s) {
		List<Song> bestSongs = getBestSongs();
		List<String> songsTitles = bestSongs.stream().map(Song::getTitle).collect(Collectors.toList());
		s.addAttribute ("songs", String.join(", ",songsTitles));
		return "songs";
	}

	
}
