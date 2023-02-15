package fr.greta92.DomesServiceSpring.entity;

import java.util.*;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "commande")
public class Commande {

    /**
     * 
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int refCommande;

    /**
     * 
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private String status;
    @OneToMany(mappedBy = "commande")
    private List<AnimalArticle> articles;
    @Embedded
    private Adresse adresse;
    
    /**
     * Default constructor
     */
    public Commande() {
    }

	public Commande(int refCommande, Client client, Date date, String status, ArrayList<AnimalArticle> articles,
			Adresse adresse) {
		super();
		this.refCommande = refCommande;
		this.client = client;
		this.date = date;
		this.status = status;
		this.articles = articles;
		this.adresse = adresse;
	}

	public int getRefCommande() {
		return refCommande;
	}

	public void setRefCommande(int refCommande) {
		this.refCommande = refCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<AnimalArticle> getArticles() {
		return articles;
	}

	public void setArticles(List<AnimalArticle> articles) {
		this.articles = articles;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
}