package fr.greta92.DomesServiceSpring.controller;

import fr.greta92.DomesServiceSpring.entity.Client;
import fr.greta92.DomesServiceSpring.entity.CompteEntity;
import fr.greta92.DomesServiceSpring.entity.ConnexionEntity;
import fr.greta92.DomesServiceSpring.exception.WrongEmailOrPasswordExecption;
import fr.greta92.DomesServiceSpring.service.GestionClient;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class Connexion {
    @Autowired
    GestionClient gestionClient;

    @GetMapping("/Connexion")
    public String navConnexion(Model model, HttpSession session)
    {
        model.addAttribute("user", new ConnexionEntity());

        Client client = (Client)session.getAttribute("client");

        if(client == null)
        {
            return "pageConnexion";
        }
        else {
            return "redirect:/Accueil";
        }
    }

    @PostMapping("/Connexion_")
    public String Connexion(@ModelAttribute("user") @Valid ConnexionEntity connexion, BindingResult br, HttpSession session)
    {
        Client client;

        System.out.println(connexion);

        if(connexion.getEmail() == null ||
                connexion.getPassword() == null)
        {
            System.out.println("HasErrors");
            return "pageConnexion";
        }
        if(connexion.getEmail().isEmpty() ||
                connexion.getPassword().isEmpty())
        {
            System.out.println("HasErrors");
            return "pageConnexion";
        }

        try {
            client = gestionClient.login(connexion.getEmail(), connexion.getPassword());
        } catch (WrongEmailOrPasswordExecption e) {
            System.out.println("WrongEmailOrPasswordExecption");
            return "pageConnexion";
        }

        session.setAttribute("client", client);

        return "redirect:/Accueil";
    }
}
