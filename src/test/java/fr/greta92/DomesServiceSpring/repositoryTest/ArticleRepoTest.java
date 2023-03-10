package fr.greta92.DomesServiceSpring.repositoryTest;

import fr.greta92.DomesServiceSpring.entity.AnimalArticle;
import fr.greta92.DomesServiceSpring.entity.Categorie;
import fr.greta92.DomesServiceSpring.entity.Race;
import fr.greta92.DomesServiceSpring.repository.ArticleRepo;
import fr.greta92.DomesServiceSpring.repository.ClientRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ArticleRepoTest {
    @Autowired
    private ArticleRepo articleRepo;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testfindByRace_returnListArticle()
    {
        Race raceChiens1 = new Race(0, "Bulldog", null, null);
        Race raceChiens2 = new Race(0, "Chihuahua", null, null);
        Race raceChats = new Race(0, "Chartreux", null, null);

        Categorie categorieChiens = new Categorie(0, "Chiens",  new ArrayList<>(Arrays.asList(raceChiens1, raceChiens2)));
        Categorie categorieChats = new Categorie(0, "Chats",  new ArrayList<>(Arrays.asList(raceChats)));

        raceChiens1.setCategorie(categorieChiens);
        raceChiens2.setCategorie(categorieChiens);
        raceChats.setCategorie(categorieChats);

        AnimalArticle alvin = new AnimalArticle(0, "Alvin", 1000, "na", 10,
                "Je suis trop mignon", true, null, raceChiens1);

        AnimalArticle rex = new AnimalArticle(0, "Rex", 45.55, "na", 5,
                "Je suis pas mignon", true, null, raceChiens1);

        AnimalArticle mimi = new AnimalArticle(0, "mimi", 900.99, "na", 1,
                "Je suis mignon", true, null, raceChiens2);

        AnimalArticle nana = new AnimalArticle(0, "Nana", 500, "na", 7,
                "Je suis pas trop mignon", true, null, raceChats);

        testEntityManager.persistAndFlush(categorieChiens);
        testEntityManager.persistAndFlush(categorieChats);

        testEntityManager.persistAndFlush(raceChiens1);
        testEntityManager.persistAndFlush(raceChiens2);
        testEntityManager.persistAndFlush(raceChats);

        AnimalArticle saveArticle1 = testEntityManager.persistAndFlush(alvin);

        AnimalArticle saveArticle2 = testEntityManager.persistAndFlush(rex);

        AnimalArticle saveArticle3 = testEntityManager.persistAndFlush(mimi);

        AnimalArticle saveArticle4 = testEntityManager.persistAndFlush(nana);

        //Normalement les articles 1 et 2 sont retournés

        List<AnimalArticle> articles = articleRepo.findByRace(raceChiens1);

        then(articles).isNotNull();
        then(articles.size()).isEqualTo(2);

        AnimalArticle article1 = articles.get(0);
        AnimalArticle article2 = articles.get(1);

        then(article1.getRef()).isEqualTo(saveArticle1.getRef());
        then(article2.getRef()).isEqualTo(saveArticle2.getRef());
    }
}
