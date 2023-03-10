package fr.greta92.DomesServiceSpring.controller;

import fr.greta92.DomesServiceSpring.entity.Client;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategorieRecherche {
    @GetMapping("/Categorie")
    public String navAccueil(Model model, HttpSession session)
    {
        model.addAttribute("client", (Client)session.getAttribute("client"));
        return "pageCategorieRecherche";
    }
}
