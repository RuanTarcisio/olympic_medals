BEGIN;

INSERT INTO public.medal_gold (id, award_date, country_id, sport_id) VALUES
                                     (1, '2024-08-24', 1, 1),
                                     (2, '2024-08-24', 2, 2),
                                     (3, '2024-08-24', 3, 3),
                                     (4, '2024-08-24', 4, 4),
                                     (5, '2024-08-24', 5, 5),
                                     (6, '2024-08-24', 2, 6);

INSERT INTO public.medal_silver (id, award_date, country_id, sport_id) VALUES
                                   (1, '2024-08-24', 1, 2),
                                   (2, '2024-08-24', 2, 3),
                                   (3, '2024-08-24', 3, 4),
                                   (4, '2024-08-24', 4, 5),
                                   (5, '2024-08-24', 5, 6);

INSERT INTO public.medal_bronze (id, award_date, country_id, sport_id) VALUES
                                   (1, '2024-08-24', 1, 3),
                                   (2, '2024-08-24', 2, 4),
                                   (3, '2024-08-24', 3, 5),
                                   (4, '2024-08-24', 4, 6),
                                   (5, '2024-08-24', 5, 7);

COMMIT;