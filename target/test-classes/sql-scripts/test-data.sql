CREATE TABLE IF NOT EXISTS movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    minutes INT NOT NULL,
    genre VARCHAR(50) NOT NULL
);

INSERT INTO movies (name, minutes, genre) VALUES
    ('The Shawshank Redemption', 142, 'DRAMA'),
    ('The Dark Knight', 152, 'ACTION'),
    ('Forrest Gump', 142, 'DRAMA');
