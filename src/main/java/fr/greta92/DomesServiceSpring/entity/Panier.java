package fr.greta92.DomesServiceSpring.entity;

import java.util.ArrayList;

public class Panier {
	private ArrayList<AnimalArticle> articles;

	public Panier(ArrayList<AnimalArticle> articles) {
		super();
		this.articles = articles;
	}

	public ArrayList<AnimalArticle> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<AnimalArticle> articles) {
		this.articles = articles;
	}
	
	public void addOneArticle(AnimalArticle article)
	{
		articles.add(article);
	}
	public AnimalArticle getOneArticle(int i)
	{
		return articles.get(i);
	}
}
