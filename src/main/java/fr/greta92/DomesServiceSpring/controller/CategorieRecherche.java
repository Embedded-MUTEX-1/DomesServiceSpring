package fr.greta92.DomesServiceSpring.controller;

import fr.greta92.DomesServiceSpring.entity.Categorie;
import fr.greta92.DomesServiceSpring.entity.Client;
import fr.greta92.DomesServiceSpring.service.GestionArticle;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategorieRecherche {

    @Autowired
    GestionArticle gestionArticle;

    @GetMapping("/Categorie")
    public String navAccueil(Model model, HttpSession session, @RequestParam(required = false) String categorie)
    {
        List<Categorie> categories = gestionArticle.returnListCategorie();

        model.addAttribute("client", (Client)session.getAttribute("client"));
        model.addAttribute("categorieList", categories);
        model.addAttribute("categorie", categorie);
        return "pageCategorieRecherche";
    }
}
