package fr.greta92.DomesServiceSpring.service;

import fr.greta92.DomesServiceSpring.entity.AnimalArticle;
import fr.greta92.DomesServiceSpring.entity.Categorie;
import fr.greta92.DomesServiceSpring.entity.Race;
import fr.greta92.DomesServiceSpring.exception.ArticleDejaExistantException;
import fr.greta92.DomesServiceSpring.exception.ArticleNonExistantException;
import fr.greta92.DomesServiceSpring.repository.ArticleRepo;
import fr.greta92.DomesServiceSpring.repository.CategorieRepo;
import fr.greta92.DomesServiceSpring.repository.RaceRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestionArticleImpl implements GestionArticle {

	@Autowired
	ArticleRepo articleRepo;
	@Autowired
	RaceRepo raceRepo;
	@Autowired
	CategorieRepo categorieRepo;

	@Override
	public boolean existArticle(int ref) {
		return articleRepo.existsById(ref);
	}

	@Override
	public void ajouterArticle(AnimalArticle article) throws ArticleDejaExistantException {
		if(existArticle(article.getRef())) {
			throw new ArticleDejaExistantException();
		}
		else {
			articleRepo.save(article);
		}
	}

	@Override
	public void modifierArticle(AnimalArticle article) throws ArticleNonExistantException {
		if(existArticle(article.getRef())) {
			articleRepo.save(article);
		}
		else {
			throw new ArticleNonExistantException();
		}
	}

	@Override
	public void supprimerArticle(AnimalArticle article) {
		articleRepo.delete(article);
	}

	@Override
	public AnimalArticle returnArticle(int id) throws ArticleNonExistantException {
		if(existArticle(id)) {

			AnimalArticle article = articleRepo.findById(id).get();

			return article;
		}
		else {
			throw new ArticleNonExistantException();
		}
	}

	@Override
	public List<AnimalArticle> returnAllArticles() {
		return articleRepo.findAll();
	}

	@Override
	public List<AnimalArticle> filterListArticleCategory(String category, double numPrixMin, double numPrixMax, int numAgeMin, int numAgeMax) {

		Categorie byCategorie = categorieRepo.findByCategorie(category);

		System.out.println(byCategorie);

		List<AnimalArticle> list = articleRepo.filterListArticleCategory(byCategorie, numPrixMin, numPrixMax, numAgeMin, numAgeMax);

		/*
		List<AnimalArticle> returnList = new ArrayList<>();

		System.out.println(list);

		for (AnimalArticle article : list) {
			Race race = article.getRace();
			//System.out.println(race);
			Categorie categorie = race.getCategorie();
			//System.out.println(categorie.getCategorie()+" "+category);

			if(categorie.getCategorie().equals(category))
			{
				//System.out.println(article);
				returnList.add(article);
			}
		}

		*/
		return list;
	}

	@Override
	public List<AnimalArticle> filterListArticleRace(String race, double numPrixMin, double numPrixMax, int numAgeMin, int numAgeMax) {

		Race byRace = raceRepo.findByRace(race);

		System.out.println(byRace);

		List<AnimalArticle> list = articleRepo.filterListArticleRace(byRace, numPrixMin, numPrixMax, numAgeMin, numAgeMax);

		/*
		List<AnimalArticle> returnList = new ArrayList<>();

		for (AnimalArticle article : list) {
			Race raceArticle = article.getRace();

			if(raceArticle.getRace().equals(race))
			{
				returnList.add(article);
			}
		}
		 */
		return list;
	}

	@Override
	public Categorie returnCategorie(String categorie)
	{
		return categorieRepo.findByCategorie(categorie);
	}
	@Override
	public Race returnRace(String race)
	{
		return raceRepo.findByRace(race);
	}
	@Override
	public List<Race> returnListRaceFromCategorie(Categorie categorie)
	{
		return raceRepo.findByCategorie(categorie);
	}
	@Override
	public List<Categorie> returnListCategorie()
	{
		return categorieRepo.findAll();
	}
	@Override
	public List<Race> returnListRace()
	{
		return raceRepo.findAll();
	}
}
