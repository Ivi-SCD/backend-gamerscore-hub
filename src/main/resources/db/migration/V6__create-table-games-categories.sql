CREATE TABLE IF NOT EXISTS tb_games_categories(
    id_game BIGINT NOT NULL,
    id_category BIGINT NOT NULL,
    PRIMARY KEY (id_game, id_category),
    FOREIGN KEY (id_game) REFERENCES tb_games(id_game),
    FOREIGN KEY (id_category) REFERENCES tb_categories(id_category)
)