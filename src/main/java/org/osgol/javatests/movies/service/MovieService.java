package org.osgol.javatests.movies.service;

import org.osgol.javatests.movies.data.MovieRepository;
import org.osgol.javatests.movies.model.Genre;
import org.osgol.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int length) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length)
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByName(String name) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByTemplate(Movie template) {

        if (template.getId() != null) {
            return Collections.singletonList(findMoviesById(template.getId()));
        }

        if (template.getMinutes() != null && template.getMinutes() < 0) {
            throw new IllegalArgumentException("Minutes must be greater than 0");
        }

        return movieRepository.findAll().stream()
                .filter(movie -> template.getName() == null || movie.getName().toLowerCase().contains(template.getName().toLowerCase()))
                .filter(movie -> template.getMinutes() == null || movie.getMinutes() <= template.getMinutes())
                .filter(movie -> template.getGenre() == null || movie.getGenre() == template.getGenre())
                .collect(Collectors.toList());
    }

    private Movie findMoviesById(Integer id) {
        return movieRepository.findById(id);
    }
}
