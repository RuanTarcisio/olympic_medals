BEGIN;

CREATE TABLE public.country (
                                id BIGSERIAL PRIMARY KEY,
                                code VARCHAR(255),
                                name VARCHAR(255)
                                );


CREATE TABLE public.sport (
                              id BIGSERIAL PRIMARY KEY,
                              qtd_participants INT,
                              description_sport VARCHAR(255),
                              name_sport VARCHAR(255));

CREATE TABLE public.medal (
                              id BIGSERIAL PRIMARY KEY,
                              award_date DATE,
                              country_id BIGINT,
                              sport_id BIGINT,
                              type VARCHAR(255) CHECK (type IN ('GOLD', 'SILVER', 'BRONZE')),
                              FOREIGN KEY (country_id) REFERENCES public.country(id),
                              FOREIGN KEY (sport_id) REFERENCES public.sport(id));

COMMIT;