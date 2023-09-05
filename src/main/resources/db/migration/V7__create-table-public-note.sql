CREATE TABLE IF NOT EXISTS tb_public_notes (
    id_public_note BIGINT AUTO_INCREMENT,
    id_user BIGINT NOT NULL,
    id_game BIGINT NOT NULL,
    animation DECIMAL(3,0),
    gameplay DECIMAL(3,0),
    narrative DECIMAL(3,0),
    soundtrack DECIMAL(3,0),
    PRIMARY KEY (id_public_note),
    FOREIGN KEY (id_user) REFERENCES tb_users (id_user),
    FOREIGN KEY (id_game) REFERENCES tb_games (id_game)
)