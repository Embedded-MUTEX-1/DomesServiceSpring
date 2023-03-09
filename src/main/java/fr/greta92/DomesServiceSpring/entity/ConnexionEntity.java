package fr.greta92.DomesServiceSpring.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ConnexionEntity {

    @NotEmpty(message="Champs requis")
    @NotNull(message="Champs requis")
    @Email(message="Email requis")
    private String email;

    @NotEmpty(message="Champs requis")
    @NotNull(message="Champs requis")
    @Size(min = 5, message = "Taille min 5")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
