CREATE TABLE IF NOT EXISTS public.client
(
    numero_client serial,
    email character varying(100),
    mot_de_passe character varying(60),
    nom character varying(60),
    prenom character varying(60),
    nom_adresse character varying(60),
    adresse character varying(60),
    code_postale character varying(20),
    ville character varying(60),
    pays character varying(60),
    telephone character varying(20),
    actif boolean,
    PRIMARY KEY (numero_client)
);

CREATE TABLE IF NOT EXISTS public.commande
(
    ref serial,
    date timestamp without time zone,
    status character varying(20),
    nom_adresse character varying(60),
    adresse character varying(60),
    code_postale character varying(60),
    ville character varying(60),
    pays character varying(60),
    numero_client integer,
    PRIMARY KEY (ref)
);

CREATE TABLE IF NOT EXISTS public.article
(
    ref serial,
    nom character varying(60),
    prix double precision,
    url character varying(100),
    description character varying(300),
    age integer,
    disponible boolean,
    id_race integer,
    id_commande integer,
    PRIMARY KEY (ref)
);

CREATE TABLE IF NOT EXISTS public.categorie
(
    id serial,
    categorie character varying(30),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.race
(
    id serial,
    race character varying(30),
    id_categorie integer,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.employe
(
    id serial,
    email character varying(100),
    mot_de_passe character varying(60),
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.commande
    ADD FOREIGN KEY (numero_client)
    REFERENCES public.client (numero_client);


ALTER TABLE IF EXISTS public.article
    ADD FOREIGN KEY (id_race)
    REFERENCES public.race (id);


ALTER TABLE IF EXISTS public.article
    ADD FOREIGN KEY (id_commande)
    REFERENCES public.commande (ref);


ALTER TABLE IF EXISTS public.race
    ADD FOREIGN KEY (id_categorie)
    REFERENCES public.categorie (id);