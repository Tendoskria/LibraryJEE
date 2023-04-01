Insertion de la base de données :

INSERT INTO author (FirstNameAuthor, LastNameAuthor) VALUES ('Gustave', 'Flaubert'), ('Albert', 'Camus');
INSERT INTO appuser (FirstNameUser, LastNameUser, privilege, login, password) VALUES ('Theo', 'Mendes', 1, 'theo.mendes', 'azertyuiop'), ('Amina', 'Ferraoun', 0, 'lilou.mendes', 'azertyuiop');
INSERT INTO genre (GenreName) VALUES ('Roman'), ('Nouvelle');
INSERT INTO book (bookTitle, idAuthor, idGenre) VALUES ('Madame Bovary',1,1), ('La Peste',2,2);
INSERT INTO borrow (idBook, startingDate, endingDate,  idUser, isBorrowEnd) VALUE (2, '2022-06-01', '2022-06-11', 2, 0);
INSERT INTO borrow (idBook, startingDate, endingDate, idUser, isBorrowEnd) VALUE (1, '2023-03-30', '2023-04-06', 1, 1);