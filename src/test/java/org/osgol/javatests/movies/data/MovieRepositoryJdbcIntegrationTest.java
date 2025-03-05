package org.osgol.javatests.movies.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgol.javatests.movies.model.Genre;
import org.osgol.javatests.movies.model.Movie;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryJdbcIntegrationTest {

    private MovieRepositoryJdbc movieRepositoryJdbc;
    private DriverManagerDataSource dataSource;

    @Before
    public void setUp() throws Exception {

        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() {

        Collection<Movie> movies = movieRepositoryJdbc.findAll();

        assertEquals(Arrays.asList(
                new Movie(1, "The Shawshank Redemption", 142, Genre.DRAMA),
                new Movie(2, "The Dark Knight", 152, Genre.ACTION),
                new Movie(3, "Forrest Gump", 142, Genre.DRAMA)
        ), movies);
    }

    @Test
    public void load_movie_by_id() {

        movieRepositoryJdbc.findById(2);

        assertEquals(new Movie(2, "The Dark Knight", 152, Genre.ACTION), movieRepositoryJdbc.findById(2));

    }

    @Test
    public void insert_a_movie() {

        Movie movie = new Movie("Super 8", 112, Genre.THRILLER);

        movieRepositoryJdbc.saveOrUpdate(movie);

        Movie newMovie = movieRepositoryJdbc.findById(4);

        assertEquals(new Movie(4, "Super 8", 112, Genre.THRILLER), newMovie);
    }

    @After
    public void tearDown() throws Exception {

        // Remove H2 files -- https://stackoverflow.com/a/51809831/1121497
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("DROP ALL OBJECTS DELETE FILES"); // "shutdown" is also enough for mem db
    }
}