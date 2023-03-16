package fr.greta92.DomesServiceSpring.repository;

import fr.greta92.DomesServiceSpring.entity.Client;
import fr.greta92.DomesServiceSpring.exception.WrongEmailOrPasswordExecption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {
    public Client getByEmail(String email);

    @Modifying
    @Query("update Client c set c.nom = :nom, c.prenom = :prenom, c.email = :email, c.telephone = :telephone where c.email = :prevemail")
    public void modifierProfile(@Param("nom")String nom,
                                @Param("prenom")String prenom,
                                @Param("email")String email,
                                @Param("telephone")String telephone,
                                @Param("prevemail")String prevEmail);

    @Modifying
    @Query("update Client c set c.adresse.addrName = :addrname, c.adresse.address = :adresse, c.adresse.postalCode = :cp, c.adresse.city = :ville , c.adresse.country = :pays where c.email = :prevemail")
    public void modifierAdresse(@Param("addrname")String addrName,
                                @Param("adresse")String adresse,
                                @Param("cp")String codePostale,
                                @Param("ville")String ville,
                                @Param("pays")String pays,
                                @Param("prevemail")String prevEmail);
}
