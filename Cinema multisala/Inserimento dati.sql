
INSERT IGNORE INTO cinema_multisala.persona VALUES
	('danielescalco@hotmail.it', '$2a$10$aObQVr9LHzrlAehp7vzvMe23wtx1Ge67QnAyx8MZ68EJZGR/CmuEq'),
	('dipendente@dipendente.it', '$2a$10$jDzLejqEYXbXqtWdk3KrieGDo/IUR2TJyhFTTDkZzzzunigQ19KJW'),
	('utente@utente.it', '$2a$10$aObQVr9LHzrlAehp7vzvMe23wtx1Ge67QnAyx8MZ68EJZGR/CmuEq');
    
INSERT IGNORE INTO cinema_multisala.ruolo VALUES
	(1, 'UTENTE'),
	(2, 'DIPENDENTE'),
	(3, 'AMMINISTRATORE');

INSERT IGNORE INTO cinema_multisala.persona_ruolo VALUES
	('danielescalco@hotmail.it', 3),
	('dipendente@dipendente.it', 2),
	('utente@utente.it', 1);
    
INSERT IGNORE INTO cinema_multisala.sala VALUES
	(1, 1),
	(2, 2),
	(3, 3);

INSERT IGNORE INTO cinema_multisala.film VALUES
    ('Avatar', CURRENT_DATE(), '19:00:00', 'L\'ex marine Jake Sully è stato reclutato per una missione sul pianeta Pandora con lo scopo di recuperare risorse naturali in esaurimento sulla Terra. Inaspettatamente si ritrova a voler proteggere il mondo magico al quale si sente stranamente legato.', 'Sam Worthington, Zoe Saldana, Stephen Lang, Michelle Rodriguez, Sigourney Weaver', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\Uploads\\Avatar.jpg') , 'James Cameron', 1),
    ('Avatar', CURRENT_DATE(), '21:00:00', 'L\'ex marine Jake Sully è stato reclutato per una missione sul pianeta Pandora con lo scopo di recuperare risorse naturali in esaurimento sulla Terra. Inaspettatamente si ritrova a voler proteggere il mondo magico al quale si sente stranamente legato.', 'Sam Worthington, Zoe Saldana, Stephen Lang, Michelle Rodriguez, Sigourney Weaver', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\Uploads\\Avatar.jpg') , 'James Cameron', 1),
    ('Avatar', CURRENT_DATE(), '23:00:00', 'L\'ex marine Jake Sully è stato reclutato per una missione sul pianeta Pandora con lo scopo di recuperare risorse naturali in esaurimento sulla Terra. Inaspettatamente si ritrova a voler proteggere il mondo magico al quale si sente stranamente legato.', 'Sam Worthington, Zoe Saldana, Stephen Lang, Michelle Rodriguez, Sigourney Weaver', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\Uploads\\Avatar.jpg') , 'James Cameron', 1),
    ('Avatar', CURRENT_DATE(), '20:00:00', 'L\'ex marine Jake Sully è stato reclutato per una missione sul pianeta Pandora con lo scopo di recuperare risorse naturali in esaurimento sulla Terra. Inaspettatamente si ritrova a voler proteggere il mondo magico al quale si sente stranamente legato.', 'Sam Worthington, Zoe Saldana, Stephen Lang, Michelle Rodriguez, Sigourney Weaver', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\Uploads\\Avatar.jpg') , 'James Cameron', 2),
    ('Avatar', CURRENT_DATE(), '22:00:00', 'L\'ex marine Jake Sully è stato reclutato per una missione sul pianeta Pandora con lo scopo di recuperare risorse naturali in esaurimento sulla Terra. Inaspettatamente si ritrova a voler proteggere il mondo magico al quale si sente stranamente legato.', 'Sam Worthington, Zoe Saldana, Stephen Lang, Michelle Rodriguez, Sigourney Weaver', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\Uploads\\Avatar.jpg') , 'James Cameron', 2),
    ('Avatar', CURRENT_DATE(), '19:30:00', 'L\'ex marine Jake Sully è stato reclutato per una missione sul pianeta Pandora con lo scopo di recuperare risorse naturali in esaurimento sulla Terra. Inaspettatamente si ritrova a voler proteggere il mondo magico al quale si sente stranamente legato.', 'Sam Worthington, Zoe Saldana, Stephen Lang, Michelle Rodriguez, Sigourney Weaver', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\Uploads\\Avatar.jpg') , 'James Cameron', 3),
    ('Avatar', CURRENT_DATE(), '21:30:00', 'L\'ex marine Jake Sully è stato reclutato per una missione sul pianeta Pandora con lo scopo di recuperare risorse naturali in esaurimento sulla Terra. Inaspettatamente si ritrova a voler proteggere il mondo magico al quale si sente stranamente legato.', 'Sam Worthington, Zoe Saldana, Stephen Lang, Michelle Rodriguez, Sigourney Weaver', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\Uploads\\Avatar.jpg') , 'James Cameron', 3),
    ('Avatar', CURRENT_DATE(), '23:30:00', 'L\'ex marine Jake Sully è stato reclutato per una missione sul pianeta Pandora con lo scopo di recuperare risorse naturali in esaurimento sulla Terra. Inaspettatamente si ritrova a voler proteggere il mondo magico al quale si sente stranamente legato.', 'Sam Worthington, Zoe Saldana, Stephen Lang, Michelle Rodriguez, Sigourney Weaver', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\Uploads\\Avatar.jpg') , 'James Cameron', 3),
	('Il Re Leone', CURRENT_DATE(), '17:00:00', 'Tradito dallo zio che ha ordito un terribile complotto per prendere il potere, il piccolo Simba, leoncino figlio del re della foresta, affronta il proprio destino nel cuore della savana.', 'Beyoncé, Donald Grover, James Earl Jones, Seth Rogen', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\Uploads\\Il Re Leone.jpg') , 'Jon Favreau', 1),
	('Il Re Leone', CURRENT_DATE(), '18:00:00', 'Tradito dallo zio che ha ordito un terribile complotto per prendere il potere, il piccolo Simba, leoncino figlio del re della foresta, affronta il proprio destino nel cuore della savana.', 'Beyoncé, Donald Grover, James Earl Jones, Seth Rogen', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\Uploads\\Il Re Leone.jpg') , 'Jon Favreau', 2),
	('Shutter Island', '2021-12-01', '21:00:00', 'Rachel Salado, paziente del manicomio criminale sull\'isola di Shutter, scompare all\'improvviso. L\'agente federale Teddy Daniels, affiancato dall\'ufficiale Chuck Aule, deve indagare per risolvere il mistero.', 'Leonardo DiCaprio, Mark Ruffalo, Ben Kingsley, Michelle Williams', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\Uploads\\Shutter Island.jpg') , 'Martin Scorsese', 1);

INSERT IGNORE INTO cinema_multisala.posto_a_sedere VALUES
	(1, 'A', 1),
	(1, 'A', 2),
	(1, 'B', 1),
	(1, 'B', 2),
    (2, 'A', 1),
	(2, 'A', 2),
	(2, 'B', 1),
	(2, 'B', 2),
    (3, 'A', 1),
	(3, 'A', 2),
	(3, 'B', 1),
	(3, 'B', 2);
