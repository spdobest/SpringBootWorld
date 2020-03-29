package spm.spring.world.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"firstName", "lastName"})
public class User extends RepresentationModel {

    @Id
    @GeneratedValue
    private Long userId;

    @Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
    private String userName;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Column(name = "EMAIL_ADDRESS", length = 50, nullable = false)
    private String emailId;

    @Column(name = "ROLE", length = 50, nullable = false)
    private String role;

    @Column(name = "SSN", length = 50, nullable = true, unique = true)
    @JsonIgnore
    private String ssn;
    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    //NO ARGUMENT CONSTRUCTOR
    public User() {
    }

    //FIELD CONSTRUCTOR
    public User(String userName, String firstName, String lastName, String emailId, String role, String ssn) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.role = role;
        this.ssn = ssn;
    }

// GETTERS AND SETTERS

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", role='" + role + '\'' +
                ", ssn='" + ssn + '\'' +
                ", orders=" + orders +
                '}';
    }
}
