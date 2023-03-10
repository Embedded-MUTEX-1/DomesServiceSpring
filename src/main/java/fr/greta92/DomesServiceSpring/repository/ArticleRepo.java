package fr.greta92.DomesServiceSpring.repository;

import fr.greta92.DomesServiceSpring.entity.AnimalArticle;
import fr.greta92.DomesServiceSpring.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArticleRepo extends JpaRepository<AnimalArticle, Integer> {
    List<AnimalArticle> findByRace(Race race);
}
