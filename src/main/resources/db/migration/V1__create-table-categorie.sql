CREATE TABLE IF NOT EXISTS tb_categories(
    id_category BIGINT AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL UNIQUE,
    PRIMARY KEY (id_category)
);