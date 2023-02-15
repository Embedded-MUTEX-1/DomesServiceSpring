package fr.greta92.DomesServiceSpring.service;

import fr.greta92.DomesServiceSpring.entity.AnimalArticle;

import java.util.ArrayList;



public class GestionArticleImpl implements GestionArticle {

	@Override
	public boolean existArticle(int ref) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ajouterArticle(AnimalArticle article) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifierArticle(AnimalArticle article) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerArticle(AnimalArticle article) {
		// TODO Auto-generated method stub

	}

	@Override
	public AnimalArticle returnArticle(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnimalArticle> returnAllArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnimalArticle> returnListeArticlePrix(double min, double max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnimalArticle> returnListeArticleAge(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnimalArticle> filterListArticleCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnimalArticle> filterListArticleRace(String race) {
		// TODO Auto-generated method stub
		return null;
	}

}
