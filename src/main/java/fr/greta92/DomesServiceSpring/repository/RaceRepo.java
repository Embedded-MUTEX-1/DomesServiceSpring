package fr.greta92.DomesServiceSpring.repository;

import fr.greta92.DomesServiceSpring.entity.AnimalArticle;
import fr.greta92.DomesServiceSpring.entity.Categorie;
import fr.greta92.DomesServiceSpring.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaceRepo extends JpaRepository<Race, Integer> {

    public Race findByRace(String race);
    public List<Race> findByCategorie(Categorie categorie);
}
