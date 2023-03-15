package fr.greta92.DomesServiceSpring.service;

import fr.greta92.DomesServiceSpring.entity.AnimalArticle;
import fr.greta92.DomesServiceSpring.entity.Categorie;
import fr.greta92.DomesServiceSpring.entity.Race;
import fr.greta92.DomesServiceSpring.exception.ArticleDejaExistantException;
import fr.greta92.DomesServiceSpring.exception.ArticleNonExistantException;

import java.util.List;

public interface GestionArticle {
	
	public boolean existArticle(int ref);
	public void ajouterArticle(AnimalArticle article) throws ArticleDejaExistantException;
	public void modifierArticle(AnimalArticle article) throws ArticleNonExistantException;
	public void supprimerArticle(AnimalArticle article);
	public AnimalArticle returnArticle(int id) throws ArticleNonExistantException;
	public List<AnimalArticle> returnAllArticles();
	public List<AnimalArticle> filterListArticleCategory(String category, double numPrixMin, double numPrixMax, int numAgeMin, int ageMin);
	public List<AnimalArticle> filterListArticleRace(String race, double numPrixMin, double numPrixMax, int numAgeMin, int ageMin);
	public Categorie returnCategorie(String categorie);
	public Race returnRace(String race);
	public List<Race> returnListRaceFromCategorie(Categorie categorie);
	public List<Categorie> returnListCategorie();
	public List<Race> returnListRace();
}
