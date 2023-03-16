package fr.greta92.DomesServiceSpring.service;

import fr.greta92.DomesServiceSpring.entity.Client;
import fr.greta92.DomesServiceSpring.exception.CompteNonDisponibleExecption;
import fr.greta92.DomesServiceSpring.exception.WrongEmailOrPasswordExecption;
import fr.greta92.DomesServiceSpring.exception.CompteDejaExistantException;
import fr.greta92.DomesServiceSpring.repository.ClientRepo;
import jakarta.persistence.NoResultException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GestionClientImpl implements GestionClient {

	@Autowired
	ClientRepo clientRepo;
	
	@Override
	public Client login(String email, String password) throws WrongEmailOrPasswordExecption, CompteNonDisponibleExecption {

		Client client = clientRepo.getByEmail(email);

		if(client == null) {
			throw new WrongEmailOrPasswordExecption();
		}
		if(!client.getActif())
		{
			throw new CompteNonDisponibleExecption();
		}
		else if(BCrypt.checkpw(password, client.getPassword())){
			return client;
		}
		else {
			throw new WrongEmailOrPasswordExecption();
		}
	}

	@Override
	public void ajouterClient(Client client) throws CompteDejaExistantException {
		// TODO Auto-generated method stub
		
		try {
			Client oldClient = clientRepo.getByEmail(client.getEmail());
			if(oldClient != null)
			{
				throw new CompteDejaExistantException();
			}
		} catch (NoResultException e) {
			
		}

		String password = client.getPassword();

		password = BCrypt.hashpw(password, BCrypt.gensalt());

		client.setPassword(password);

		clientRepo.save(client);
	}

	@Override
	public void modifierClient(Client client) {
		clientRepo.save(client);
	}

	@Override
	public void supprimerClient(Client client) {
		clientRepo.delete(client);
	}

	@Override
	public boolean alreadyExist(Client client) {

		if(returnClient(client.getEmail()) == null)
		{
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public void modifierProfile(Client client, String prevEmail) {
		clientRepo.modifierProfile(client.getNom(), client.getPrenom(), client.getEmail(), client.getTelephone(), prevEmail);
	}

	@Override
	@Transactional
	public void modifierAdresse(Client client) {
		clientRepo.modifierAdresse(client.getAdresse().getAddrName(),
				client.getAdresse().getAddress(),
				client.getAdresse().getPostalCode(),
				client.getAdresse().getCity(),
				client.getAdresse().getCountry(),
				client.getEmail());
	}

	@Override
	public Client returnClient(String email) {
		return clientRepo.getByEmail(email);
	}

	@Override
	public Client returnClient(int id) {
		return clientRepo.findById(id).get();
	}

}
