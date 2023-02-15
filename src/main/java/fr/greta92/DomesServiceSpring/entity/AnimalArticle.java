package fr.greta92.DomesServiceSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "article")
public class AnimalArticle {

	/**
     * 
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ref;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private double price;

    /**
     * 
     */
    private String imgUrl;

    /**
     * 
     */
    private String category;

    /**
     * 
     */
    private int age;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private boolean disponible;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_commande")
    private Commande commande;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_race")
    private Race race;
	
    /**
     * Default constructor
     */
    public AnimalArticle() {
    }
    
    public AnimalArticle(int ref, String name, double price, String imgUrl, String category, int age,
			String description, boolean disponible, Commande commande, Race race) {
		super();
		this.ref = ref;
		this.name = name;
		this.price = price;
		this.imgUrl = imgUrl;
		this.category = category;
		this.age = age;
		this.description = description;
		this.disponible = disponible;
		this.commande = commande;
		this.race = race;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}
}