package org.osgol.javatests.movies.model;

import java.util.Objects;

public class Movie {

    private final Integer id;
    private final String name;
    private final Integer minutes;
    private final Genre genre;

    public Movie(String name, Integer minutes, Genre genre) {
        this(null, name, minutes, genre);
    }

    public Movie(Integer id, String name, Integer minutes, Genre genre) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMinutes() {
        return minutes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return minutes.equals(movie.minutes) && Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, minutes, genre);
    }
}
