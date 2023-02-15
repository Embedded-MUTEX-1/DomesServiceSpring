package fr.greta92.DomesServiceSpring.service;

import fr.greta92.domesServices.entity.Commande;

public interface GestionCommande {
	public void ajouterCommande(Commande commande);
	public void modifierCommande(Commande commande);
	public void supprimerCommande(Commande commande);
}
