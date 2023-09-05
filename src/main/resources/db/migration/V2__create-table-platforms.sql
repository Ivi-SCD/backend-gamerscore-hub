CREATE TABLE IF NOT EXISTS tb_platforms(
    id_platform BIGINT AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL UNIQUE,
    PRIMARY KEY(id_platform)
);