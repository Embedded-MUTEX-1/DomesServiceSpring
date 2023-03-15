package fr.greta92.DomesServiceSpring.entity;

import java.util.*;

import jakarta.persistence.*;

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
    private int ref;

    /**
     * 
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "numero_client")
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

	public Commande(int ref, Client client, Date date, String status, ArrayList<AnimalArticle> articles,
			Adresse adresse) {
		super();
		this.ref = ref;
		this.client = client;
		this.date = date;
		this.status = status;
		this.articles = articles;
		this.adresse = adresse;
	}

	public int getRefCommande() {
		return ref;
	}

	public void setRefCommande(int refCommande) {
		this.ref = refCommande;
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