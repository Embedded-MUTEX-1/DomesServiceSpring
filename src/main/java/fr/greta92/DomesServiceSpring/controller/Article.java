package fr.greta92.DomesServiceSpring.controller;

import fr.greta92.DomesServiceSpring.entity.AnimalArticle;
import fr.greta92.DomesServiceSpring.entity.Categorie;
import fr.greta92.DomesServiceSpring.entity.Client;
import fr.greta92.DomesServiceSpring.entity.Race;
import fr.greta92.DomesServiceSpring.exception.ArticleNonExistantException;
import fr.greta92.DomesServiceSpring.service.GestionArticle;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Controller
public class Article {

    @Autowired
    GestionArticle gestionArticle;
    @GetMapping("/Animal")
    public String navAccueil(Model model, HttpSession session, @RequestParam(required = true) String id)
    {
        AnimalArticle article;
        try {
            article = gestionArticle.returnArticle(Integer.valueOf(id));
        }
        catch (NumberFormatException e)
        {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Error"
            );
        } catch (ArticleNonExistantException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        Race race =  article.getRace();

        Hibernate.initialize(race);

        model.addAttribute("client", (Client)session.getAttribute("client"));
        model.addAttribute("article", article);
        model.addAttribute("race", race);

        return "pageProduit";
    }
}
