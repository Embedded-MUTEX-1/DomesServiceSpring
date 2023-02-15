package fr.greta92.DomesServiceSpring.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "race")
public class Race {

    /**
     * 
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 
     */
    private String race;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;
    @OneToMany(mappedBy = "race")
    private List<AnimalArticle> animaux;

    /**
     * Default constructor
     */
    public Race() {
    }

	public Race(int id, String race, Categorie categorie, List<AnimalArticle> animaux) {
		super();
		this.id = id;
		this.race = race;
		this.categorie = categorie;
		this.animaux = animaux;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<AnimalArticle> getAnimaux() {
		return animaux;
	}

	public void setAnimaux(List<AnimalArticle> animaux) {
		this.animaux = animaux;
	}
}