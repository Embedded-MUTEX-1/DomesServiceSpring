package fr.greta92.DomesServiceSpring.controller;

import fr.greta92.DomesServiceSpring.entity.Client;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Accueil {
    @RequestMapping(value={"/", "/Accueil"}, method = RequestMethod.GET)
    public String navAccueil(Model model, HttpSession session)
    {
        model.addAttribute("client", (Client)session.getAttribute("client"));
        return "pageAccueil";
    }
}
