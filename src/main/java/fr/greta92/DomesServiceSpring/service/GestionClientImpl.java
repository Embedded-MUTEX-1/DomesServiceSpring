package fr.greta92.DomesServiceSpring.service;

import org.apache.tomcat.util.bcel.Const;
import org.mindrot.jbcrypt.BCrypt;

import fr.greta92.domesServices.dao.ClientDao;
import fr.greta92.domesServices.entity.Client;
import fr.greta92.domesServices.exception.CompteDejaExistantException;
import fr.greta92.domesServices.exception.WrongEmailOrPasswordExecption;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;


@Stateless
public class GestionClientImpl implements GestionClient {
	
	@Inject
	ClientDao clientDao;
	
	@Override
	public Client login(String email, String password) throws WrongEmailOrPasswordExecption {
		return clientDao.login(email, password);
	}

	@Override
	public void ajouterClient(Client client) throws CompteDejaExistantException {
		// TODO Auto-generated method stub
		
		try {
			Client oldClient = clientDao.returnClient(client.getEmail());
			throw new CompteDejaExistantException();
		} catch (NoResultException e) {
			
		}
		
		clientDao.ajouterClient(client);
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
