CREATE TABLE IF NOT EXISTS tb_games_platforms(
    id_game BIGINT NOT NULL,
    id_platform BIGINT NOT NULL,
    PRIMARY KEY (id_game, id_platform),
    FOREIGN KEY (id_game) REFERENCES tb_games(id_game),
    FOREIGN KEY (id_platform) REFERENCES tb_platforms(id_platform)
);