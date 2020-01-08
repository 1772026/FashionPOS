package fashionPOS.Model.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Tbuser {
    private int userId;
    private String userUsername;
    private String userPassword;
    private String userName;
    private Tbrole tbroleByTbroleRoleId;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_username", nullable = false, length = 50)
    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 50)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 100)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbuser tbuser = (Tbuser) o;
        return userId == tbuser.userId &&
                Objects.equals(userUsername, tbuser.userUsername) &&
                Objects.equals(userPassword, tbuser.userPassword) &&
                Objects.equals(userName, tbuser.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userUsername, userPassword, userName);
    }

    @ManyToOne
    @JoinColumn(name = "tbrole_role_id", referencedColumnName = "role_id", nullable = false)
    public Tbrole getTbroleByTbroleRoleId() {
        return tbroleByTbroleRoleId;
    }

    public void setTbroleByTbroleRoleId(Tbrole tbroleByTbroleRoleId) {
        this.tbroleByTbroleRoleId = tbroleByTbroleRoleId;
    }
}
