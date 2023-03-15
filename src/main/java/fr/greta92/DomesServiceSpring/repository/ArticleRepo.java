package fr.greta92.DomesServiceSpring.repository;

import fr.greta92.DomesServiceSpring.entity.AnimalArticle;
import fr.greta92.DomesServiceSpring.entity.Categorie;
import fr.greta92.DomesServiceSpring.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepo extends JpaRepository<AnimalArticle, Integer> {
    List<AnimalArticle> findByRace(Race race);
    @Query("SELECT a FROM AnimalArticle a JOIN a.race r JOIN r.categorie c WHERE c = :categorie AND a.price >= :prixmin AND a.price <= :prixmax AND a.age >= :agemin AND a.age <= :agemax AND a.disponible = TRUE")
    List<AnimalArticle> filterListArticleCategory(@Param("categorie") Categorie categorie,
                                                  @Param("prixmin") double numPrixMin,
                                                  @Param("prixmax") double numPrixMax,
                                                  @Param("agemin") int ageMin,
                                                  @Param("agemax") int ageMax);

    @Query("SELECT a FROM AnimalArticle a WHERE a.race = :race AND a.disponible = TRUE AND a.price >= :prixmin AND a.price <= :prixmax AND a.age >= :agemin AND a.age <= :agemax")
    List<AnimalArticle> filterListArticleRace(@Param("race") Race byRace,
                                              @Param("prixmin") double numPrixMin,
                                              @Param("prixmax") double numPrixMax,
                                              @Param("agemin") int ageMin,
                                              @Param("agemax") int ageMax);
}
