package fashionPOS.Model.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Tbrole {
    private int roleId;
    private String roleName;
    private Collection<Tbuser> tbusersByRoleId;

    @Id
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 45)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbrole tbrole = (Tbrole) o;
        return roleId == tbrole.roleId &&
                Objects.equals(roleName, tbrole.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName);
    }

    @OneToMany(mappedBy = "tbroleByTbroleRoleId")
    public Collection<Tbuser> getTbusersByRoleId() {
        return tbusersByRoleId;
    }

    public void setTbusersByRoleId(Collection<Tbuser> tbusersByRoleId) {
        this.tbusersByRoleId = tbusersByRoleId;
    }
}
