package fr.greta92.DomesServiceSpring.service;

import fr.greta92.DomesServiceSpring.entity.Employe;

public interface GestionEmploye {
	public boolean login(String email, String password);
	public void ajouterEmploye(Employe employe);
	public void modifierEmploye(Employe employe);
	public void supprimerEmploye(Employe employe);
}
