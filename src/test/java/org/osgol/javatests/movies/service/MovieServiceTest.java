package org.osgol.javatests.movies.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.osgol.javatests.movies.data.MovieRepository;
import org.osgol.javatests.movies.model.Genre;
import org.osgol.javatests.movies.model.Movie;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceTest {

    MovieRepository movieRepository;
    MovieService movieService;

    @Before
    public void setUp() {

        movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Super 8", 112, Genre.THRILLER),
                        new Movie(2, "Superman", 90, Genre.ACTION),
                        new Movie(3, "Norbit", 150, Genre.COMEDY),
                        new Movie(4, "The Shawshank Redemption", 142, Genre.DRAMA),
                        new Movie(5, "The Dark Knight", 152, Genre.ACTION),
                        new Movie(6, "Forrest Gump", 154, Genre.DRAMA)
                )
        );

        Mockito.when(movieRepository.findById(Mockito.anyLong())).thenReturn(
                new Movie(6, "Forrest Gump", 154, Genre.DRAMA)
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_template_id() {

        Integer id = 6;
        String name = null;
        Integer minutes = null;
        Genre genre = null;

        Movie template = new Movie(id, name, minutes, genre);

        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(template);

        List<Integer> movieIds = getMovieIds(moviesByTemplate);

        assertEquals(Collections.singletonList(6), movieIds);
    }

    @Test
    public void return_movies_by_template_name() {

        String name = "the";
        Integer minutes = null;
        Genre genre = null;

        Movie template = new Movie(name, minutes, genre);

        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(template);

        List<Integer> movieIds = getMovieIds(moviesByTemplate);

        assertEquals(Arrays.asList(4, 5), movieIds);
    }

    @Test
    public void return_movies_by_template_minutes() {

        String name = null;
        Integer minutes = 160;
        Genre genre = null;

        Movie template = new Movie(name, minutes, genre);

        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(template);

        List<Integer> movieIds = getMovieIds(moviesByTemplate);

        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), movieIds);
    }

    @Test(expected = IllegalArgumentException.class)
    public void return_movies_by_template_negative_minutes() {

        String name = null;
        Integer minutes = -90;
        Genre genre = null;

        Movie template = new Movie(name, minutes, genre);

        movieService.findMoviesByTemplate(template);
    }

    @Test
    public void return_movies_by_template_name_and_minutes() {

        String name = "No";
        Integer minutes = 200;
        Genre genre = null;

        Movie template = new Movie(name, minutes, genre);

        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(template);

        List<Integer> movieIds = getMovieIds(moviesByTemplate);

        assertEquals(Collections.singletonList(3), movieIds);
    }

    @Test
    public void return_movies_by_template_name_and_genre() {

        String name = "red";
        Integer minutes = null;
        Genre genre = Genre.DRAMA;

        Movie template = new Movie(name, minutes, genre);

        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(template);

        List<Integer> movieIds = getMovieIds(moviesByTemplate);

        assertEquals(Collections.singletonList(4), movieIds);
    }

    @Test
    public void return_movies_by_template_minutes_and_genre() {

        String name = null;
        Integer minutes = 150;
        Genre genre = Genre.ACTION;

        Movie template = new Movie(name, minutes, genre);

        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(template);

        List<Integer> movieIds = getMovieIds(moviesByTemplate);

        assertEquals(Collections.singletonList(2), movieIds);
    }

    @Test
    public void return_movies_by_template_name_minutes_and_genre() {

        String name = "super";
        Integer minutes = 149;
        Genre genre = Genre.THRILLER;

        Movie template = new Movie(name, minutes, genre);

        Collection<Movie> moviesByTemplate = movieService.findMoviesByTemplate(template);

        List<Integer> movieIds = getMovieIds(moviesByTemplate);

        assertEquals(Collections.singletonList(1), movieIds);
    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie> moviesByGenre = movieService.findMoviesByGenre(Genre.COMEDY);

        List<Integer> movieIds = getMovieIds(moviesByGenre);

        assertEquals(Collections.singletonList(3), movieIds);
    }

    @Test
    public void return_movies_by_length() {

        Collection<Movie> moviesByLength = movieService.findMoviesByLength(120);

        List<Integer> movieIds = getMovieIds(moviesByLength);

        assertEquals(Arrays.asList(1, 2), movieIds);
    }

    @Test
    public void return_movies_by_name() {

        Collection<Movie> moviesByName = movieService.findMoviesByName("super");

        List<Integer> movieIds = getMovieIds(moviesByName);

        assertEquals(Arrays.asList(1, 2), movieIds);
    }



    private static List<Integer> getMovieIds(Collection<Movie> movies) {
        if (movies == null) {
            return Collections.emptyList();
        }

        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}