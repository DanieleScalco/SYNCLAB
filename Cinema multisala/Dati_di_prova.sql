-- Inserimento dati per provare db

INSERT IGNORE INTO cinema_multisala.persona VALUES
('alicescalco@hotmail.it', 'password', 'UTENTE'),
('danielescalco@hotmail.it', 'password', 'ADMIN');

INSERT IGNORE INTO cinema_multisala.film VALUES
('titolo', '2020-04-09', '19:00', 'descrizione', 'cast', 'immagine', 'regista'),
('titolo', '2020-04-09', '20:00', 'descrizione', 'cast', 'immagine', 'regista');

INSERT IGNORE INTO cinema_multisala.posto_a_sedere VALUES
(1, 2, 3),
(1, 3, 3);
