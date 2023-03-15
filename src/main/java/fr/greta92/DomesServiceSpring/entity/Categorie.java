package fr.greta92.DomesServiceSpring.entity;

import java.util.*;

import jakarta.persistence.*;

/**
 * 
 */
@Entity
@Table(name = "categorie")
public class Categorie {

    /**
     * 
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 
     */
    private String categorie;
    @OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
    private List<Race> races;

    /**
     * Default constructor
     */
    public Categorie() {
    }
    
	public Categorie(int id, String categorie, List<Race> races) {
		super();
		this.id = id;
		this.categorie = categorie;
		this.races = races;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public List<Race> getRaces() {
		return races;
	}

	public void setRaces(List<Race> races) {
		this.races = races;
	}
}