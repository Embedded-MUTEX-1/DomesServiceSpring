INSERT INTO public.categorie(
	categorie)
	VALUES ('Chiens');
INSERT INTO public.categorie(
	categorie)
	VALUES ('Chats');

INSERT INTO public.race(
	race, id_categorie)
	VALUES ('Chihuahua', 1);

INSERT INTO public.race(
	race, id_categorie)
	VALUES ('Caniche', 1);

INSERT INTO public.race(
	race, id_categorie)
	VALUES ('Chartreux', 2);

INSERT INTO public.article(
	nom, prix, url, description, age, disponible, id_race, id_commande)
	VALUES ('Alvin', 100.99, '/img_articles/Alvin.png', 'je suis trop mignon', 10, true, 1, NULL);

INSERT INTO public.article(
	nom, prix, url, description, age, disponible, id_race, id_commande)
	VALUES ('Rex', 500.99, '/img_articles/Alvin.png', 'je suis mignon', 2, true, 1, NULL);

INSERT INTO public.article(
	nom, prix, url, description, age, disponible, id_race, id_commande)
	VALUES ('Toto', 1200, '/img_articles/Alvin.png', 'je suis pas mignon', 5, true, 2, NULL);

INSERT INTO public.article(
	nom, prix, url, description, age, disponible, id_race, id_commande)
	VALUES ('titi', 100.99, '/img_articles/Alvin.png', 'je suis pas trop mignon', 7, true, 3, NULL);