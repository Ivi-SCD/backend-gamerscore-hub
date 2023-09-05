CREATE TABLE IF NOT EXISTS tb_games(
    id_game BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(1000) NOT NULL,
    release_year DATE NOT NULL,
    age_classification ENUM('L', '10', '12', '14', '16', '18') NOT NULL,
    thumb_url VARCHAR(500),
    critics_note DECIMAL(3,0),
    public_note DECIMAL(2,1),
    developer VARCHAR(50),
    PRIMARY KEY (id_game)
);