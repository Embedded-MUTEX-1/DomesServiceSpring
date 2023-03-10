package fr.greta92.DomesServiceSpring.repositoryTest;

import fr.greta92.DomesServiceSpring.entity.Categorie;
import fr.greta92.DomesServiceSpring.entity.Race;
import fr.greta92.DomesServiceSpring.repository.ArticleRepo;
import fr.greta92.DomesServiceSpring.repository.RaceRepo;
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
public class RaceRepoTest {
    @Autowired
    private RaceRepo raceRepo;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testFindByCategorie_returnListRace()
    {
        Race saveRaceChiens1 = new Race(0, "Bulldog", null, null);
        Race saveRaceChiens2 = new Race(0, "Chihuahua", null, null);
        Race saveRaceChats = new Race(0, "Chartreux", null, null);

        Categorie categorieChiens = new Categorie(0, "Chiens",  new ArrayList<>(Arrays.asList(saveRaceChiens1, saveRaceChiens2)));
        Categorie categorieChats = new Categorie(0, "Chats",  new ArrayList<>(Arrays.asList(saveRaceChats)));

        saveRaceChiens1.setCategorie(categorieChiens);
        saveRaceChiens2.setCategorie(categorieChiens);
        saveRaceChats.setCategorie(categorieChats);

        testEntityManager.persistAndFlush(categorieChiens);
        testEntityManager.persistAndFlush(categorieChats);

        saveRaceChiens1 = testEntityManager.persistAndFlush(saveRaceChiens1);
        saveRaceChiens2 = testEntityManager.persistAndFlush(saveRaceChiens2);
        saveRaceChats = testEntityManager.persistAndFlush(saveRaceChats);

        List<Race> listRaceChiens = raceRepo.findByCategorie(categorieChiens);

        then(listRaceChiens).isNotNull();
        then(listRaceChiens.size()).isEqualTo(2);

        then(listRaceChiens.get(0).getRace()).isEqualTo("Bulldog");
        then(listRaceChiens.get(1).getRace()).isEqualTo("Chihuahua");
    }

    @Test
    void testFindByRaceName_returnRace()
    {
        Race saveRaceChiens1 = new Race(0, "Bulldog", null, null);
        saveRaceChiens1 = testEntityManager.persistAndFlush(saveRaceChiens1);

        Race race = raceRepo.findByRace("Bulldog");

        then(race).isNotNull();
        then(race.getRace()).isEqualTo("Bulldog");
    }
}