package spm.spring.world.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/*
@NoArgsConstructor annotation for generating a constructor with no parameters
*/
@NoArgsConstructor
/*
@AllArgsConstructor annotation for generating a constructor
with 1 parameter for each field
*/
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String email;
    private String mobileNumber;
    // https://attacomsian.com/blog/spring-data-jpa-one-to-one-mapping#
//    private Address address;

}
