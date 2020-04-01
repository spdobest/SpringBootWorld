package spm.spring.client.entities;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.transaction.support.ResourceHolderSupport;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user")
@ApiModel(description = "Mode to Create a new user")
//@JsonIgnoreProperties({"firstName", "lastName"}) - this is Static Filtering @JsonIgnore
//@JsonFilter(value = "userFilter") // this is dynamic filtering
public class User extends ResourceHolderSupport {

    @ApiModelProperty(notes = "auto generated unique id", required = true, position = 1)
    @Id
    @GeneratedValue
    @JsonView(Views.External.class)
    private Long userId;

    @NotEmpty(message = "Username is Mandatory field, Please Provide username")
    @Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
    @JsonView(Views.External.class)
    private String userName;

    @Size(min = 2, message = "FirstName should have atleast 2 characters")
    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    @JsonView(Views.External.class)
    private String firstName;

    @Size(min = 2, message = "address should have atleast 2 characters")
    @Column(name = "ADDRESS", length = 50, nullable = false)
    private String address;

    //FIELD CONSTRUCTOR
    public User(String userName, String firstName, String lastName, String emailId, String role, String ssn, String address) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.role = role;
        this.ssn = ssn;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    @JsonView(Views.External.class)
    private String lastName;

    @Column(name = "EMAIL_ADDRESS", length = 50, nullable = false)
    @JsonView(Views.External.class)
    private String emailId;

    @Column(name = "ROLE", length = 50, nullable = false)
    @JsonView(Views.Internal.class)
    private String role;

    @Column(name = "SSN", length = 50, nullable = true, unique = true)
//    @JsonIgnore  -- this is static filtering
    @JsonView(Views.Internal.class)
    private String ssn;

    @OneToMany(mappedBy = "user")
    @JsonView(Views.Internal.class)
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

    public void setAddress(String address) {
        this.address = address;
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
                ", address='" + address + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", role='" + role + '\'' +
                ", ssn='" + ssn + '\'' +
                ", orders=" + orders +
                '}';
    }
}
