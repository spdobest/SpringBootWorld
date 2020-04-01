package spm.spring.client.dtos;

public class UserMsDto {

    private Long userId;
    private String userName;
    private String emailaddress;
    private String roleNumber;

    public UserMsDto(){}

    public UserMsDto(Long userId, String userName, String emailaddress, String roleNumber) {
        this.userId = userId;
        this.userName = userName;
        this.emailaddress = emailaddress;
        this.roleNumber = roleNumber;
    }

    public String getroleNumber() {
        return roleNumber;
    }

    public void setroleNumber(String roleNumber) {
        this.roleNumber = roleNumber;
    }

    public Long getuserId() {
        return userId;
    }

    public void setuserId(Long userId) {
        this.userId = userId;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    @Override
    public String toString() {
        return "UserMsDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", emailaddress='" + emailaddress + '\'' +
                '}';
    }
}
