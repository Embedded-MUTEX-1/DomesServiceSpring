package fr.greta92.DomesServiceSpring.controllerRest;

import fr.greta92.DomesServiceSpring.entity.AnimalArticle;
import fr.greta92.DomesServiceSpring.entity.Categorie;
import fr.greta92.DomesServiceSpring.entity.Race;
import fr.greta92.DomesServiceSpring.exception.ArticleDejaExistantException;
import fr.greta92.DomesServiceSpring.exception.ArticleNonExistantException;
import fr.greta92.DomesServiceSpring.service.GestionArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleRessource {

    @Autowired
    GestionArticle gestionArticle;

    @GetMapping("/api/article/{id}")
    public AnimalArticle getArticle(@PathVariable("id") int id)
    {
        try {
            return gestionArticle.returnArticle(id);
        } catch (ArticleNonExistantException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

    @PostMapping("/api/article")
    public void setArticle(@RequestBody AnimalArticle article)
    {
        try {
            gestionArticle.ajouterArticle(article);
        } catch (ArticleDejaExistantException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "entity already exist"
            );
        }
    }

    @PutMapping("/api/article")
    public void updateArticle(@RequestBody AnimalArticle article)
    {
        try {
            gestionArticle.modifierArticle(article);
        } catch (ArticleNonExistantException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

    @GetMapping("/api/articles/all")
    public List<AnimalArticle> getAllArticle()
    {
            try{
                return gestionArticle.returnAllArticles();
            } catch (Exception e) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Error"
                );
            }
    }

    @GetMapping("/api/articles")
    public List<AnimalArticle> getArticles(
            @RequestParam(required = true) String trier,
            @RequestParam(required = true) String prixMin,
            @RequestParam(required = true) String prixMax,
            @RequestParam(required = true) String ageMin,
            @RequestParam(required = true) String ageMax,
            @RequestParam(required = true) String filtrer)
    {
        try {
            List<AnimalArticle> returnList = new ArrayList<>();

            if (!trier.equals("0") && !trier.equals("1") && !trier.equals("2") && !trier.equals("3") && !trier.equals("4")) {
                System.out.println("trier bad request");
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Error"
                );
            }

            double numPrixMin = Double.valueOf(prixMin);
            double numPrixMax = Double.valueOf(prixMax);
            int numAgeMin = Integer.valueOf(ageMin);
            int numAgeMax = Integer.valueOf(ageMax);

            List<Categorie> categories = gestionArticle.returnListCategorie();
            List<String> listCategorie = new ArrayList<>();

            List<Race> races = gestionArticle.returnListRace();
            List<String> listRace = new ArrayList<>();

            for (Categorie categorie : categories)
                listCategorie.add(categorie.getCategorie());

            for (Race race : races)
                listRace.add(race.getRace());

            if(!listCategorie.contains(filtrer) && !listRace.contains(filtrer))
            {
                System.out.println("Categorie/Race bad request");

                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Error"
                );
            }

            if(listCategorie.contains(filtrer))
                returnList = gestionArticle.filterListArticleCategory(filtrer, numPrixMin, numPrixMax, numAgeMin, numAgeMax);

            else if(listRace.contains(filtrer))
                returnList = gestionArticle.filterListArticleRace(filtrer, numPrixMin, numPrixMax, numAgeMin, numAgeMax);

            return returnList;

        } catch (NumberFormatException e) {
            System.out.println("Number format bad request");
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Error"
            );
        }
    }
}
