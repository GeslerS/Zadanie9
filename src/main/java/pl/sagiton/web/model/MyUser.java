package pl.sagiton.web.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by szymon on 03.03.16.
 */
@Entity
@Table(name="USERS")
public class MyUser {

    @Id
    @Column(name = "id")
    @GeneratedValue
    @Setter @Getter private Integer id;

    @Column(name = "username")
    @Setter @Getter private String username;

    @Column(name = "password")
    @Setter @Getter private String password;


}
