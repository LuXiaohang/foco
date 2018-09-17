package cornell.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProfileForm {
    @Id
    private String username;
    private String password;

    public ProfileForm() {}

    public ProfileForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ProfileForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
