package fr.greta92.DomesServiceSpring.repositoryTest;

import fr.greta92.DomesServiceSpring.entity.Categorie;
import fr.greta92.DomesServiceSpring.entity.Race;
import fr.greta92.DomesServiceSpring.repository.CategorieRepo;
import fr.greta92.DomesServiceSpring.repository.RaceRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategorieRepoTest {
    @Autowired
    private CategorieRepo categorieRepo;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testFindByCategorieName_returnCategorie() {
        Categorie saveCategorieChiens = new Categorie(0, "Chiens", null);
        saveCategorieChiens = testEntityManager.persistAndFlush(saveCategorieChiens);

        Categorie categorie = categorieRepo.findByCategorie("Chiens");

        then(categorie).isNotNull();
        then(categorie.getCategorie()).isEqualTo("Chiens");
    }
}