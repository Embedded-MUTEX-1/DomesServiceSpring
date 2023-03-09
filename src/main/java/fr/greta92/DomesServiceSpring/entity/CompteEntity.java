package fr.greta92.DomesServiceSpring.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CompteEntity {

    @NotEmpty(message="Champs requis")
    @NotNull(message="Champs requis")
    private String nom;

    @NotEmpty(message="Champs requis")
    @NotNull(message="Champs requis")
    private String prenom;

    @NotEmpty(message="Champs requis")
    @NotNull(message="Champs requis")
    @Email(message="Email requis")
    private String email;

    @NotEmpty(message="Champs requis")
    @NotNull(message="Champs requis")
    @Size(min = 5, message = "Taille min 5")
    private String password1;

    @NotEmpty(message="Champs requis")
    @NotNull(message="Champs requis")
    @Size(min = 5, message = "Taille min 5")
    private String password2;

    public CompteEntity() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
