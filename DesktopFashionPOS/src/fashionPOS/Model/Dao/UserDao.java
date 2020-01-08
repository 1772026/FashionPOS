package fashionPOS.Model.Dao;

import fashionPOS.Model.Entity.Tbuser;
import fashionPOS.Util.DaoServiceCRUD;
import fashionPOS.Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements DaoServiceCRUD<Tbuser> {

    @Override
    public int addData(Tbuser object) {
        int result = 0;
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(object);
            transaction.commit();
            result = 1;
        } catch (HibernateException e) {
            transaction.rollback();
        }
        return result;
    }

    @Override
    public List<Tbuser> getAllData() {
        List<Tbuser> tbusers = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Tbuser.class);
        tbusers.addAll(criteria.list());
        return null;
    }

    @Override
    public Tbuser getData(Tbuser object) {
        Session session = HibernateUtil.getSession();

        Criteria criteria = session.createCriteria(Tbuser.class);
        List<Tbuser> tbusers = new ArrayList<>();
        tbusers.addAll(criteria.list());
        Tbuser isidata = new Tbuser();
        for (Tbuser data : tbusers) {
            if (data.getUserUsername().equals(object.getUserName())) {
                isidata = data;
                break;
            }
        }
        return isidata;
    }

    @Override
    public int updateData(Tbuser object) {
        int result = 0;
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(object);
            transaction.commit();
            result = 1;
        } catch (HibernateException e) {
            transaction.rollback();
        }
        return result;
    }

    @Override
    public int deleteData(Tbuser object) {
        int result = 0;
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(object);
            transaction.commit();
            result = 1;
        } catch (HibernateException e) {
            transaction.rollback();
        }
        return result;
    }
}
