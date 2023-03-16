package fr.greta92.DomesServiceSpring.entity;

import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "client")
public class Client {

    /**
     * 
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_client")
    private int numClient;

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private String prenom;

    /**
     * 
     */
    @Column(name = "mot_de_passe")
    private String password;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String telephone;


    /**
     * 
     */
    private boolean actif;
    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;
    @Embedded
    private Adresse adresse;

    /**
     * Default constructor
     */
    public Client() {
    }
    
	public Client(int numClient, String nom, String prenom, String password, String email, String telephone,
			boolean actif, ArrayList<Commande> commandes, Adresse adresse) {
		super();
		this.numClient = numClient;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.email = email;
		this.telephone = telephone;
		this.actif = actif;
		this.commandes = commandes;
		this.adresse = adresse;
	}

	public int getNumClient() {
		return numClient;
	}

	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean getActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
}