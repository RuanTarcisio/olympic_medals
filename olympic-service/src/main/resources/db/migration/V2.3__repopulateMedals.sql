begin;




INSERT INTO public.medal_gold (id, award_date, country_id, atlet_id, sport_id) VALUES
                                                                                    (1, '2024-08-24', 1, 14, 1),
                                                                                    (2, '2024-08-24', 2, 21, 2),
                                                                                    (3, '2024-08-24', 3, 25, 3),
                                                                                    (4, '2024-08-24', 4, 24, 4),
                                                                                    (5, '2024-08-24', 5, 28, 5),
                                                                                    (6, '2024-08-24', 2, 29, 6);

INSERT INTO public.medal_silver (id, award_date, country_id, atlet_id, sport_id) VALUES
                                                                                      (1, '2024-08-24', 1, 14, 2),
                                                                                      (2, '2024-08-24', 2, 21, 3),
                                                                                      (3, '2024-08-24', 3, 17, 4),
                                                                                      (4, '2024-08-24', 4, 23, 5),
                                                                                      (5, '2024-08-24', 5, 15, 6);


INSERT INTO public.medal_bronze (id, award_date, country_id, atlet_id, sport_id) VALUES
                                                                                    (1, '2024-08-24', 1, 1, 3),
                                                                                    (2, '2024-08-24', 2, 6, 4),
                                                                                    (3, '2024-08-24', 6, 8, 5),
                                                                                    (4, '2024-08-24', 35, 3, 6),
                                                                                    (5, '2024-08-24', 3, 15, 7);

commit;