package fr.greta92.DomesServiceSpring.service;

import fr.greta92.DomesServiceSpring.entity.AnimalArticle;

import java.util.ArrayList;

public interface GestionArticle {
	
	public boolean existArticle(int ref);
	public void ajouterArticle(AnimalArticle article);
	public void modifierArticle(AnimalArticle article);
	public void supprimerArticle(AnimalArticle article);
	
	public AnimalArticle returnArticle(int id);
	public ArrayList<AnimalArticle> returnAllArticles();
	public ArrayList<AnimalArticle> returnListeArticlePrix(double min, double max);
	public ArrayList<AnimalArticle> returnListeArticleAge(int min, int max);
	public ArrayList<AnimalArticle> filterListArticleCategory(String category);
	public ArrayList<AnimalArticle> filterListArticleRace(String race);
}
