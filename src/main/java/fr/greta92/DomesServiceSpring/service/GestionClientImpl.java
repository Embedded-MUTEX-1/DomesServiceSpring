package fr.greta92.DomesServiceSpring.service;

import fr.greta92.DomesServiceSpring.entity.Client;
import fr.greta92.DomesServiceSpring.exception.WrongEmailOrPasswordExecption;
import fr.greta92.DomesServiceSpring.exception.CompteDejaExistantException;
import fr.greta92.DomesServiceSpring.repository.ClientRepo;
import jakarta.persistence.NoResultException;



public class GestionClientImpl implements GestionClient {

	ClientRepo clientRepo;
	
	@Override
	public Client login(String email, String password) throws WrongEmailOrPasswordExecption {
		return clientRepo.getByEmail(email);
	}

	@Override
	public void ajouterClient(Client client) throws CompteDejaExistantException {
		// TODO Auto-generated method stub
		
		try {
			Client oldClient = clientRepo.getByEmail(client.getEmail());
			throw new CompteDejaExistantException();
		} catch (NoResultException e) {
			
		}
		
		clientRepo.save(client);
	}

	@Override
	public void modifierClient(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerClient(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client returnClient(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client returnClient(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
