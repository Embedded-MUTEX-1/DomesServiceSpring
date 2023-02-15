package fr.greta92.DomesServiceSpring.entity;

import java.util.*;

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
    @OneToMany(mappedBy = "categorie")
    private ArrayList<Race> races;

    /**
     * Default constructor
     */
    public Categorie() {
    }
    
	public Categorie(int id, String categorie, ArrayList<Race> races) {
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

	public ArrayList<Race> getRaces() {
		return races;
	}

	public void setRaces(ArrayList<Race> races) {
		this.races = races;
	}
}