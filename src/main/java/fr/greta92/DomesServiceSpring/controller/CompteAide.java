package fr.greta92.DomesServiceSpring.controller;

import fr.greta92.DomesServiceSpring.entity.Adresse;
import fr.greta92.DomesServiceSpring.entity.Categorie;
import fr.greta92.DomesServiceSpring.entity.Client;
import fr.greta92.DomesServiceSpring.service.GestionClient;
import jakarta.persistence.Access;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CompteAide {

    @Autowired
    GestionClient gestionClient;

    @GetMapping("/AideCompte")
    public String navAccueil(Model model, HttpSession session)
    {
        if(session.getAttribute("client") == null)
        {
            model.addAttribute("client", new Client());
        }
        else {
            model.addAttribute("client", session.getAttribute("client"));
        }

        return "pageCompteAide";
    }

    @PostMapping("/ModifierAdresse")
    public String modifierAdresse(@ModelAttribute("client") Client client, HttpSession session)
    {

        Adresse adresse = client.getAdresse();
        if(adresse == null)
            return "redirect:/AideCompte";

        if(adresse.getAddress()         == null ||
                adresse.getAddrName()   == null ||
                adresse.getPostalCode() == null ||
                adresse.getCity()       == null ||
                adresse.getCountry()    == null)
        {
            System.out.println("HasErrors null");
            System.out.println(adresse);
            return "redirect:/AideCompte";
        }
        if(adresse.getAddress().isEmpty()         ||
                adresse.getAddrName().isEmpty()   ||
                adresse.getPostalCode().isEmpty() ||
                adresse.getCity().isEmpty()       ||
                adresse.getCountry().isEmpty())
        {
            System.out.println("HasErrors empty");
            return "redirect:/AideCompte";
        }

        Client prevClient = (Client)session.getAttribute("client");

        if(gestionClient.alreadyExist(prevClient))
        {
            client.setEmail(prevClient.getEmail());
            gestionClient.modifierAdresse(client);
            session.setAttribute("client", gestionClient.returnClient(prevClient.getEmail()));
        }

        return "redirect:/AideCompte";
    }
    @PostMapping("/ModifierCompte")
    public String modifierClient(@ModelAttribute("client") Client client, HttpSession session)
    {
        if(client.getNom()            == null ||
                client.getPrenom()    == null ||
                client.getEmail()     == null ||
                client.getTelephone() == null)
        {
            System.out.println("HasErrors");
            return "redirect:/AideCompte";
        }
        if(client.getNom().isEmpty()            ||
                client.getPrenom().isEmpty()    ||
                client.getEmail().isEmpty()     ||
                client.getTelephone().isEmpty())
        {
            System.out.println("HasErrors");
            return "redirect:/AideCompte";
        }

        Client prevClient = (Client)session.getAttribute("client");

        if(gestionClient.alreadyExist(prevClient))
        {
            gestionClient.modifierProfile(client, prevClient.getEmail());

            session.setAttribute("client", (Client)gestionClient.returnClient(client.getEmail()));
        }

        return "redirect:/AideCompte";
    }
    @GetMapping("/SeDeconnecter")
    public String seDeconnecter(HttpSession session)
    {
        session.setAttribute("client", null);
        return "redirect:/AideCompte";
    }
    @GetMapping("/SupprimerCompte")
    public String supprimerCompte(HttpSession session)
    {
        Client client = (Client)session.getAttribute("client");

        if(client == null)
            return "redirect:/AideCompte";

        client.setActif(false);

        gestionClient.modifierClient(client);

        session.setAttribute("client", null);

        return "redirect:/AideCompte";
    }

}
