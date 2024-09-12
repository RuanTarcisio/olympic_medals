BEGIN;

INSERT INTO delegacao (id_delegacao, country_name, total_atletas)
VALUES
    (1, 'United States', 200),
    (2, 'Brazil', 100),
    (3, 'China', 200),
    (4, 'Japan', 150),
    (5, 'Germany', 120),
    (6, 'France', 130),
    (7, 'Great Britain', 110),
    (8, 'Russia', 140),
    (9, 'Italy', 90),
    (10, 'Canada', 80),
    (11, 'Australia', 95),
    (12, 'South Korea', 85),
    (13, 'Netherlands', 105),
    (14, 'Hungary', 70),
    (15, 'Spain', 75),
    (16, 'Kenya', 65),
    (17, 'Jamaica', 60),
    (18, 'Sweden', 55),
    (19, 'Cuba', 50),
    (20, 'New Zealand', 45),
    (21, 'Uzbekistan', 40),
    (22, 'Kazakhstan', 35),
    (23, 'Colombia', 30),
    (24, 'Switzerland', 25),
    (25, 'Norway', 20),
    (26, 'Belgium', 15),
    (27, 'Thailand', 10),
    (28, 'Azerbaijan', 5),
    (29, 'Poland', 3),
    (30, 'Iran', 2),
    (31, 'Greece', 120),
    (32, 'Argentina', 110),
    (33, 'Denmark', 90),
    (34, 'Czech Republic', 80),
    (35, 'Ethiopia', 70),
    (36, 'Finland', 60),
    (37, 'Portugal', 50),
    (38, 'Turkey', 40),
    (39, 'Tunisia', 30),
    (40, 'Dominican Republic', 20),
    (41, 'Ireland', 10),
    (42, 'Israel', 5),
    (43, 'Bulgaria', 3),
    (44, 'Chinese Taipei', 2),
    (45, 'Serbia', 1),
    (46, 'Mexico', 4),
    (47, 'Belarus', 6),
    (48, 'Slovakia', 7),
    (49, 'Georgia', 8),
    (50, 'Slovenia', 9);



UPDATE country
SET delegacao_id = id_delegacao
    FROM delegacao
WHERE country.id = delegacao.id_delegacao;


INSERT INTO atleta (id_atleta, nome, idade, delegacao_id)
VALUES
    (1, 'Michael Phelps', 35, 1),
    (2, 'Usain Bolt', 34, 17),
    (3, 'Simone Biles', 24, 1),
    (4, 'Neymar Jr', 29, 2),
    (5, 'Kevin Durant', 32, 1),
    (6, 'Allyson Felix', 35, 1),
    (7, 'Yulimar Rojas', 25, 23),
    (8, 'Mo Farah', 37, 7),
    (9, 'Lionel Messi', 34, 32),
    (10, 'Naomi Osaka', 23, 4),
    (11, 'Roger Federer', 40, 24),
    (12, 'Rafael Nadal', 35, 37),
    (13, 'Novak Djokovic', 34, 45),
    (14, 'Katie Ledecky', 24, 1),
    (15, 'Gabby Douglas', 25, 1),
    (16, 'Eliud Kipchoge', 36, 16),
    (17, 'Shelly-Ann Fraser-Pryce', 34, 17),
    (18, 'Luka Modric', 36, 31),
    (19, 'Cristiano Ronaldo', 36, 37),
    (20, 'Serena Williams', 40, 1),
    (21, 'Kylian Mbappe', 22, 26),
    (22, 'Paul Pogba', 28, 6),
    (23, 'Megan Rapinoe', 36, 1),
    (24, 'LeBron James', 36, 1),
    (25, 'Antoine Griezmann', 30, 6),
    (26, 'Tom Brady', 44, 1),
    (27, 'Venus Williams', 41, 1),
    (28, 'Phil Mickelson', 51, 1),
    (29, 'Tiger Woods', 45, 1),
    (30, 'Andy Murray', 34, 7),
    (31, 'Gareth Bale', 32, 25),
    (32, 'Marcelo Vieira', 33, 2),
    (33, 'Sadio Mane', 29, 16),
    (34, 'Virat Kohli', 32, 38),
    (35, 'Sachin Tendulkar', 48, 38),
    (36, 'Usain Bolt', 34, 17),
    (37, 'Son Heung-Min', 29, 12),
    (38, 'Gigi Buffon', 43, 9),
    (39, 'Robert Lewandowski', 33, 29),
    (40, 'Manuel Neuer', 35, 5),
    (41, 'Romelu Lukaku', 28, 26),
    (42, 'Zlatan Ibrahimovic', 40, 10),
    (43, 'Kevin De Bruyne', 30, 26),
    (44, 'Harry Kane', 28, 7),
    (45, 'Karim Benzema', 33, 6),
    (46, 'Joshua Kimmich', 26, 5),
    (47, 'Trent Alexander-Arnold', 23, 7),
    (48, 'Virgil van Dijk', 30, 13),
    (49, 'Thibaut Courtois', 29, 26),
    (50, 'Neymar Jr', 29, 2),
    (51, 'David Beckham', 46, 7),
    (52, 'Edinson Cavani', 34, 32),
    (53, 'Paulo Dybala', 27, 32),
    (54, 'Luis Suarez', 34, 32),
    (55, 'Ruben Dias', 24, 37),
    (56, 'Joao Felix', 21, 37),
    (57, 'Diogo Jota', 24, 37),
    (58, 'Bernardo Silva', 27, 37),
    (59, 'Cristiano Ronaldo', 36, 37),
    (60, 'Luka Modric', 36, 31),
    (61, 'Keylor Navas', 34, 40),
    (62, 'Angel Di Maria', 33, 32),
    (63, 'Koke', 29, 15),
    (64, 'Sergio Ramos', 35, 15),
    (65, 'Gerard Pique', 34, 15),
    (66, 'Sergio Busquets', 33, 15),
    (67, 'Dani Alves', 38, 2),
    (68, 'Casemiro', 29, 2),
    (69, 'Toni Kroos', 31, 5),
    (70, 'Raheem Sterling', 26, 7),
    (71, 'Mohamed Salah', 29, 38),
    (72, 'Pierre-Emerick Aubameyang', 32, 16),
    (73, 'Thomas Partey', 28, 16),
    (74, 'Romario', 55, 2),
    (75, 'Diego Maradona', 60, 32),
    (76, 'Zinedine Zidane', 49, 6),
    (77, 'Ronaldinho', 41, 2),
    (78, 'Rivaldo', 49, 2),
    (79, 'Kaka', 39, 2),
    (80, 'David Luiz', 34, 2),
    (81, 'Thiago Silva', 36, 2),
    (82, 'Marcelo Bielsa', 66, 32),
    (83, 'Andrea Pirlo', 42, 9),
    (84, 'Paolo Maldini', 53, 9),
    (85, 'Frank Lampard', 43, 7),
    (86, 'Steven Gerrard', 41, 7),
    (87, 'Gianluigi Donnarumma', 22, 9),
    (88, 'Leonardo Bonucci', 34, 9),
    (89, 'Giorgio Chiellini', 37, 9),
    (90, 'Matthijs de Ligt', 22, 48),
    (91, 'Frenkie de Jong', 24, 13),
    (92, 'Ryan Gravenberch', 19, 13),
    (93, 'Memphis Depay', 27, 13),
    (94, 'Hakim Ziyech', 28, 13),
    (95, 'Christian Pulisic', 23, 1),
    (96, 'Weston McKennie', 23, 1),
    (97, 'Gio Reyna', 18, 1),
    (98, 'Sergino Dest', 21, 1),
    (99, 'Jordan Henderson', 31, 7),
    (100, 'Harry Maguire', 28, 7);

-- Associar esportes aos atletas
INSERT INTO atletas_sports (atleta_id, sport_id)
VALUES
    -- Atletas com múltiplos esportes
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 4),
    (2, 5),
    (3, 6),
    (3, 7),
    (4, 8),
    (5, 9),
    (6, 4),
    (6, 5),
    (7, 4),
    (7, 5),
    (8, 4),
    (8, 5),
    (9, 8),
    (10, 10),
    (11, 10),
    (12, 10),
    (13, 10),
    (14, 1),
    (14, 2),
    (15, 6),
    (15, 7),
    (16, 4),
    (16, 5),
    (17, 4),
    (17, 5),
    (18, 8),
    (19, 8),
    (20, 10),
    (21, 1), (21, 2), (21, 3), -- Kylian Mbappe
    (22, 1), (22, 4), -- Paul Pogba
    (23, 1), (23, 5), -- Megan Rapinoe
    (24, 2), (24, 4), -- LeBron James
    (25, 1), (25, 3), (25, 4), -- Antoine Griezmann
    (26, 1), (26, 4), -- Tom Brady
    (27, 2), -- Venus Williams
    (28, 5), -- Phil Mickelson
    (29, 5), (29, 6), -- Tiger Woods
    (30, 1), (30, 3), -- Andy Murray
    (31, 2), (31, 4), -- Gareth Bale
    (32, 2), (32, 4), -- Marcelo Vieira
    (33, 1), (33, 4), -- Sadio Mane
    (34, 5), (34, 6), -- Virat Kohli
    (35, 5), (35, 6), -- Sachin Tendulkar
    (36, 1), (36, 3), -- Usain Bolt
    (37, 1), (37, 4), -- Son Heung-Min
    (38, 1), (38, 5), -- Gigi Buffon
    (39, 1), (39, 4), -- Robert Lewandowski
    (40, 1), (40, 3), -- Manuel Neuer
    (41, 1), (41, 4), -- Romelu Lukaku
    (42, 1), (42, 3), -- Zlatan Ibrahimovic
    (43, 1), (43, 4), -- Kevin De Bruyne
    (44, 1), (44, 4), -- Harry Kane
    (45, 1), (45, 3), -- Karim Benzema
    (46, 1), (46, 5), -- Joshua Kimmich
    (47, 1), (47, 3), -- Trent Alexander-Arnold
    (48, 1), (48, 4), -- Virgil van Dijk
    (49, 1), (49, 3), -- Thibaut Courtois
    (50, 1), (50, 4), -- Neymar Jr
    (51, 1), (51, 3), -- David Beckham
    (52, 1), (52, 5), -- Edinson Cavani
    (53, 1), (53, 4), -- Paulo Dybala
    (54, 1), (54, 5), -- Luis Suarez
    (55, 1), (55, 4), -- Ruben Dias
    (56, 1), (56, 4), -- Joao Felix
    (57, 1), (57, 5), -- Diogo Jota
    (58, 1), (58, 4), -- Bernardo Silva
    (59, 1), (59, 3), -- Cristiano Ronaldo
    (60, 1), (60, 5), -- Luka Modric
    (61, 1), (61, 4), -- Keylor Navas
    (62, 1), (62, 5), -- Angel Di Maria
    (63, 1), (63, 4), -- Koke
    (64, 1), (64, 3), -- Sergio Ramos
    (65, 1), (65, 4), -- Gerard Pique
    (66, 1), (66, 5), -- Sergio Busquets
    (67, 1), (67, 3), -- Dani Alves
    (68, 1), (68, 4), -- Casemiro
    (69, 1), (69, 5), -- Toni Kroos
    (70, 1), (70, 4), -- Raheem Sterling
    (71, 1), (71, 5), -- Mohamed Salah
    (72, 1), (72, 4), -- Pierre-Emerick Aubameyang
    (73, 1), (73, 5), -- Thomas Partey
    (74, 1), (74, 4), -- Romario
    (75, 1), (75, 5), -- Diego Maradona
    (76, 1), (76, 4), -- Zinedine Zidane
    (77, 1), (77, 5), -- Ronaldinho
    (78, 1), (78, 4), -- Rivaldo
    (79, 1), (79, 5), -- Kaka
    (80, 1), (80, 4), -- David Luiz
    (81, 1), (81, 5), -- Thiago Silva
    (82, 1), (82, 4), -- Marcelo Bielsa
    (83, 1), (83, 5), -- Andrea Pirlo
    (84, 1), (84, 4), -- Paolo Maldini
    (85, 1), (85, 5), -- Frank Lampard
    (86, 1), (86, 4), -- Steven Gerrard
    (87, 1), (87, 5), -- Gianluigi Donnarumma
    (88, 1), (88, 4), -- Leonardo Bonucci
    (89, 1), (89, 5), -- Giorgio Chiellini
    (90, 1), (90, 4), -- Matthijs de Ligt
    (91, 1), (91, 5), -- Frenkie de Jong
    (92, 1), (92, 4), -- Ryan Gravenberch
    (93, 1), (93, 5), -- Memphis Depay
    (94, 1), (94, 4), -- Hakim Ziyech
    (95, 1), (95, 5), -- Christian Pulisic
    (96, 1), (96, 4), -- Weston McKennie
    (97, 1), (97, 5), -- Gio Reyna
    (98, 1), (98, 4), -- Sergino Dest
    (99, 1), (99, 5), -- Jordan Henderson
    (100, 1), (100, 4); -- Harry Maguire

COMMIT;