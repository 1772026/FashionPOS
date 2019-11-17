package fashionPOS.Model.Dao;

import fashionPOS.Model.Entity.Tbuser;
import fashionPOS.Util.DaoServiceLOGIN;
import fashionPOS.Util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class LoginDao implements DaoServiceLOGIN<Tbuser> {

    @Override
    public boolean login(Tbuser tbuser) {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Tbuser.class);
        List<Tbuser> tbusers = new ArrayList<>(criteria.list());
        for (Tbuser data : tbusers) {
            if (data.getUsername().equals(tbuser.getUsername()) && data.getPassword().equals(tbuser.getPassword())) return true;
        }
        return false;
    }
}
