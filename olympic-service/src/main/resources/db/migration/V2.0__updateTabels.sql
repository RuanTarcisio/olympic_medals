BEGIN;
-- Criação da tabela delegacao
CREATE TABLE delegacao (
                           id_delegacao BIGINT NOT NULL ,
                           country_name varchar(40),
                           total_atletas INTEGER NOT NULL,
                           PRIMARY KEY (id_delegacao)
);

CREATE TABLE atleta (
                        id_atleta BIGINT NOT NULL,
                        nome varchar(70) not null,
                        idade int,
                        delegacao_id BIGINT,
                        PRIMARY KEY (id_atleta),
                        FOREIGN KEY (delegacao_id) REFERENCES delegacao (id_delegacao)
);



CREATE TABLE atletas_sports (
                                atleta_id BIGINT NOT NULL,
                                sport_id BIGINT NOT NULL,
                                PRIMARY KEY (atleta_id, sport_id),
                                FOREIGN KEY (atleta_id) REFERENCES atleta (id_atleta),
                                FOREIGN KEY (sport_id) REFERENCES sport (id)
);

ALTER TABLE country
    ADD COLUMN delegacao_id BIGINT;

ALTER TABLE country
    ADD CONSTRAINT FK_delegacao_id UNIQUE (delegacao_id);

ALTER TABLE country
    ADD CONSTRAINT fk_delegaao
        FOREIGN KEY (delegacao_id)
            REFERENCES delegacao (id_delegacao);

COMMIT;