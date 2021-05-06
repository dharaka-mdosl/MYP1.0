package entities;

public class User {

    private String userName;
    private String fullName;
    private String email;
    private String hotelCode;
    private String mainRole;
    private String role;
    private String sSOPassword;
    private String myPRole;

    public User(String userName, String fullName, String email, String hotelCode, String mainRole, String role, String sSOPassword, String myPRole) {
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.hotelCode = hotelCode;
        this.mainRole = mainRole;
        this.role = role;
        this.sSOPassword = sSOPassword;
        this.myPRole = myPRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getMainRole() {
        return mainRole;
    }

    public void setMainRole(String mainRole) {
        this.mainRole = mainRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getsSOPassword() {
        return sSOPassword;
    }

    public void setsSOPassword(String sSOPassword) {
        this.sSOPassword = sSOPassword;
    }

    public String getMyPRole() {
        return myPRole;
    }

    public void setMyPRole(String myPRole) {
        this.myPRole = myPRole;
    }
}
