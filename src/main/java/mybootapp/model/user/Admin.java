package mybootapp.model.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import mybootapp.model.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Data
@Getter
@NoArgsConstructor
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty(message = "Key authentication is required")
    int key;

    public void addAdmin(String mail){
        //aller chercher l'utilisateur dans la bdd avec le mail et le passer en admin
    }

    public void deleteAdmin(String mail){
        //aller chercher l'admin dans la bdd avec le mail et le passer en prof
    }

    public void approveUser(String mail){
        //valide les privilèges de l'utilisateur avec la mail
    }

    public void attributeWorks(Repository repo){
        //appeller l'algo principal
    }
}
