Insertion de la base de données :

INSERT INTO author (FirstNameAuthor, LastNameAuthor) VALUES ('Gustave', 'Flaubert'), ('Albert', 'Camus');
INSERT INTO appuser (FirstNameUser, LastNameUser, privilege, login, password) VALUES ('Theo', 'Mendes', 1, 'theo.mendes', 'azertyuiop'), ('Amina', 'Ferraoun', 0, 'lilou.mendes', 'azertyuiop');
INSERT INTO genre (GenreName) VALUES ('Roman'), ('Nouvelle');
INSERT INTO book (bookTitle, idAuthor, idGenre) VALUES ('Madame Bovary',1,1), ('La Peste',2,2);
INSERT INTO borrowdate (idBook, endingDate, startingDate, idUser) VALUE (1, '2023-06-01', '2023-06-11', 2);
INSERT INTO borrowdate (idBook, endingDate, startingDate, idUser) VALUE (2, '2023-05-30', '2023-06-09', 2);
