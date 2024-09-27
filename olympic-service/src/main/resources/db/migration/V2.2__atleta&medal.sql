BEGIN;




ALTER TABLE medal_gold
    ADD COLUMN atlet_id BIGINT,
    ADD CONSTRAINT fk_atlet
        FOREIGN KEY (atlet_id)
            REFERENCES atleta (id_Atleta);

ALTER TABLE medal_silver
    ADD COLUMN atlet_id BIGINT,
    ADD CONSTRAINT fk_atlet
        FOREIGN KEY (atlet_id)
            REFERENCES atleta (id_Atleta);

ALTER TABLE medal_bronze
    ADD COLUMN atlet_id BIGINT,
    ADD CONSTRAINT fk_atlet
        FOREIGN KEY (atlet_id)
            REFERENCES atleta (id_Atleta);

truncate table  medal_gold;
truncate table medal_silver;
truncate table medal_bronze;


COMMIT;