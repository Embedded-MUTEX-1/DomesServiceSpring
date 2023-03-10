package fr.greta92.DomesServiceSpring.repository;

import fr.greta92.DomesServiceSpring.entity.Categorie;
import fr.greta92.DomesServiceSpring.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepo extends JpaRepository<Categorie, Integer> {
    public Categorie findByCategorie(String categorie);
}
