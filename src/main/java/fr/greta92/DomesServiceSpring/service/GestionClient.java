package fr.greta92.DomesServiceSpring.service;

public interface GestionClient {
	public Client login(String email, String password) throws WrongEmailOrPasswordExecption;
	public Client returnClient(String email);
	public Client returnClient(int id);
	public void ajouterClient(Client client) throws CompteDejaExistantException;
	public void modifierClient(Client client);
	public void supprimerClient(Client client);
}
