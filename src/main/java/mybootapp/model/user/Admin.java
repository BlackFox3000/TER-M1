package mybootapp.model.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import mybootapp.model.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Data
@Getter
@NoArgsConstructor
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Basic(optional = false)
    @NotEmpty(message = "Key authentication is required")
    int key;

    public Admin(int key){
        super();
        this.key = key;
    }
}
