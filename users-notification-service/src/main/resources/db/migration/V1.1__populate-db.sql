 INSERT INTO public.usuario
(id, cpf, data_nascimento, email, nome, "password", "role", status_usuario)
VALUES(1, '01421501503', '1994-04-06', 'ruantarciisio@admin.com', 'Ruan Tarcisio', '$2a$12$JW/ieheYP35Fx1zcxA40Ae7wmD03lGb9LNKCw7Rpo2OQ3nrjEXMFK', 'ADMIN', 'ATIVO');

INSERT INTO public.usuario
(id, cpf, data_nascimento, email, nome, "password", "role", status_usuario)
VALUES(2, '01234567890', '2000-11-06', 'sarah@admin.com', 'Sarah', '$2a$12$JW/ieheYP35Fx1zcxA40Ae7wmD03lGb9LNKCw7Rpo2OQ3nrjEXMFK', 'ADMIN', 'ATIVO');

 INSERT INTO public.country (id, code, "name")
 VALUES
     (1, 'USA', 'United States'),
     (2, 'BRA', 'Brazil'),
     (3, 'CHN', 'China'),
     (4, 'JPN', 'Japan'),
     (5, 'GER', 'Germany'),
     (6, 'FRA', 'France'),
     (7, 'GBR', 'Great Britain'),
     (8, 'RUS', 'Russia'),
     (9, 'ITA', 'Italy'),
     (10, 'CAN', 'Canada'),
     (11, 'AUS', 'Australia'),
     (12, 'KOR', 'South Korea'),
     (13, 'NED', 'Netherlands'),
     (14, 'HUN', 'Hungary'),
     (15, 'ESP', 'Spain'),
     (16, 'KEN', 'Kenya'),
     (17, 'JAM', 'Jamaica'),
     (18, 'SWE', 'Sweden'),
     (19, 'CUB', 'Cuba'),
     (20, 'NZL', 'New Zealand'),
     (21, 'UZB', 'Uzbekistan'),
     (22, 'KAZ', 'Kazakhstan'),
     (23, 'COL', 'Colombia'),
     (24, 'SWI', 'Switzerland'),
     (25, 'NOR', 'Norway'),
     (26, 'BEL', 'Belgium'),
     (27, 'THA', 'Thailand'),
     (28, 'AZE', 'Azerbaijan'),
     (29, 'POL', 'Poland'),
     (30, 'IRI', 'Iran'),
     (31, 'GRE', 'Greece'),
     (32, 'ARG', 'Argentina'),
     (33, 'DEN', 'Denmark'),
     (34, 'CZE', 'Czech Republic'),
     (35, 'ETH', 'Ethiopia'),
     (36, 'FIN', 'Finland'),
     (37, 'POR', 'Portugal'),
     (38, 'TUR', 'Turkey'),
     (39, 'TUN', 'Tunisia'),
     (40, 'DOM', 'Dominican Republic'),
     (41, 'IRL', 'Ireland'),
     (42, 'ISR', 'Israel'),
     (43, 'BUL', 'Bulgaria'),
     (44, 'TPE', 'Chinese Taipei'),
     (45, 'SRB', 'Serbia'),
     (46, 'MEX', 'Mexico'),
     (47, 'BLR', 'Belarus'),
     (48, 'SVK', 'Slovakia'),
     (49, 'GEO', 'Georgia'),
     (50, 'SLO', 'Slovenia');


INSERT INTO usuario_country (usuario_id, country_id) VALUES (1, 1);
INSERT INTO usuario_country (usuario_id, country_id) VALUES (1, 2);
