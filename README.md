# Spécification de l'application
Un utilisateur peut se connecter/déconnecter (normal ou admin).
Des sessions sont mises en place donc l'affichage de l'interface change en fonction du privilège de l'utilisateur.

Un utilistateur peut parcourir l'ensemble des livres de la bibliothèque. 
Il peut également filtrer les résultats.
Il peut reserver des livres jusqu'à 5 maximum, au delà un message s'affiche lui disant qu'il ne peut en réserver que 5.

L'utilisateur peut voir ses réservations en cours et voit celle qui sont "en retard" c'est à dire 10 jours après qu'il ait réservé.

Un administrateur peut gérer le rendu d'un livre et ainsi un utilisateur peut le réserver à nouveau.


# Script d'insertion de la base de données
```
INSERT INTO author (FirstNameAuthor, LastNameAuthor) VALUES ('Gustave', 'Flaubert'), ('Albert', 'Camus'), ('J. K.', 'Rowling'), ('Victor', 'Hugo');
INSERT INTO appuser (FirstNameUser, LastNameUser, privilege, login, password) VALUES ('Theo', 'Mendes', 1, 'admin', 'password'), ('Amina', 'Ferraoun', 0, 'user', 'password');
INSERT INTO genre (GenreName) VALUES ('Roman'), ('Nouvelle');
INSERT INTO book (bookTitle, idAuthor, idGenre) VALUES ('Madame Bovary',1,1), ('La Peste',2,2), ('Harry Potter à l école des sorciers',3,1), ('L étranger',2,1), ('Les misérables',4,1), ('Les vieux Conte',1,1);
INSERT INTO borrow (idBook, startingDate, endingDate,  idUser, isBorrowEnd) VALUE (2, '2022-06-01', '2022-06-11', 2, 0);
INSERT INTO borrow (idBook, startingDate, endingDate, idUser, isBorrowEnd) VALUE (1, '2023-03-30', '2023-04-06', 1, 1);
```

# Schéma de la base de données
![Schéma de la base de donées](/assets/Schema_DDD.png)

# Architecture MVC de l'application
![Architecture MVC de l'application](/assests/Diagramme_De_Classe.png)