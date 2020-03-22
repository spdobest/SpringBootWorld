package spm.spring.world.entities;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

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
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", role='" + role + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USER_NAME", length = 50, nullable = false,unique = true)
    private String userName;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Column(name = "EMAIL_ADDRESS", length = 50, nullable = false)
    private String emailId;

    @Column(name = "ROLE", length = 50, nullable = false)
    private String role;

    @Column(name = "SSN", length = 50, nullable = false,unique = true)
    private String ssn;
}
