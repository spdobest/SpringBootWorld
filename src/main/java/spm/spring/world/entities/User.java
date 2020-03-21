package spm.spring.world.entities;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USER_Name")
    private String userName;
    private String firstName;
    private String lastName;
    private String emailId;
    private String role;
    private String ssn;
}
