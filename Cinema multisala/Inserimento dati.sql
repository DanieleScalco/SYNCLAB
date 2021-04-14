
INSERT IGNORE INTO cinema_multisala.persona VALUES
	('danielescalco@hotmail.it', 'password', 'ADMIN');

INSERT IGNORE INTO cinema_multisala.film VALUES
	('Avatar', '2021-12-01', '21:00:00', 'descrizione', 'cast', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\Uploads\\Avatar.jpg') , 'regista');

INSERT IGNORE INTO cinema_multisala.posto_a_sedere VALUES
	(1, 2, 3);
    
INSERT IGNORE INTO cinema_multisala.prenotazione (mail_prenotazione, film, `data`, orario) VALUES
	('danielescalco@hotmail.it', 'Avatar', '2021-12-01', '21:00:00');
    
INSERT IGNORE INTO cinema_multisala.posti_prenotazione VALUES
	(2, 1, 2, 3);
