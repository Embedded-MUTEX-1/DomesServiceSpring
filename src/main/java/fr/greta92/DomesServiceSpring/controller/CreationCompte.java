package fr.greta92.DomesServiceSpring.controller;

import fr.greta92.DomesServiceSpring.entity.Client;
import fr.greta92.DomesServiceSpring.entity.CompteEntity;
import fr.greta92.DomesServiceSpring.exception.CompteDejaExistantException;
import fr.greta92.DomesServiceSpring.service.GestionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


@Controller
public class CreationCompte {

    @Autowired
    GestionClient gestionClient;

    @GetMapping("/CreationCompte")
    public String navCreationCompte(Model model)
    {
        model.addAttribute("user", new CompteEntity());
        return "pageCreerCompte";
    }

    @PostMapping("/CreationCompte_")
    public String CreationCompte(@ModelAttribute("user") @Valid CompteEntity compteEntity, BindingResult br)
    {

        if(compteEntity.getNom()            == null ||
                compteEntity.getPrenom()    == null ||
                compteEntity.getEmail()     == null ||
                compteEntity.getPassword1() == null ||
                compteEntity.getPassword2() == null)
        {
            System.out.println("HasErrors");
            return "pageCreerCompte";
        }
        if(compteEntity.getNom().isEmpty()            ||
                compteEntity.getPrenom().isEmpty()    ||
                compteEntity.getEmail().isEmpty()     ||
                compteEntity.getPassword1().isEmpty() ||
                compteEntity.getPassword2().isEmpty())
        {
            System.out.println("HasErrors");
            return "pageCreerCompte";
        }

        /*
        if(br.hasErrors())
        {
            System.out.println("HasErrors");
            return "pageCreerCompte";
        }
        else
            System.out.println("No Errors");
        */
        Client client = new Client();

        client.setActif(true);
        client.setNom(compteEntity.getNom());
        client.setPrenom(compteEntity.getPrenom());
        client.setEmail(compteEntity.getEmail());
        client.setPassword(compteEntity.getPassword1());

        try {
            gestionClient.ajouterClient(client);
        } catch (CompteDejaExistantException e) {
            System.out.println("CompteDejaExistantException");
            return "pageCreerCompte";
        }

        System.out.println("No Errors");

        return "pageConnexion";
    }
}
