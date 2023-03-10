package fr.greta92.DomesServiceSpring.repository;

import fr.greta92.DomesServiceSpring.entity.Client;
import fr.greta92.DomesServiceSpring.exception.WrongEmailOrPasswordExecption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {
    public Client getByEmail(String email);
}
