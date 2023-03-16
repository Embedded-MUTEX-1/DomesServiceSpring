package fr.greta92.DomesServiceSpring.service;

import fr.greta92.DomesServiceSpring.entity.Client;
import fr.greta92.DomesServiceSpring.exception.CompteDejaExistantException;
import fr.greta92.DomesServiceSpring.exception.CompteNonDisponibleExecption;
import fr.greta92.DomesServiceSpring.exception.WrongEmailOrPasswordExecption;

public interface GestionClient {
	public Client login(String email, String password) throws WrongEmailOrPasswordExecption, CompteNonDisponibleExecption;
	public Client returnClient(String email);
	public Client returnClient(int id);
	public void ajouterClient(Client client) throws CompteDejaExistantException;
	public void modifierClient(Client client);
	public void supprimerClient(Client client);
	public boolean alreadyExist(Client client);
	public void modifierProfile(Client client, String prevEmail);
	public void modifierAdresse(Client client);
}
