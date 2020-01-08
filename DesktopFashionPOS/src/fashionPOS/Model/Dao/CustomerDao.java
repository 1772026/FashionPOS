package fashionPOS.Model.Dao;

import fashionPOS.Model.Entity.Tbcustomer;
import fashionPOS.Util.DaoServiceCRUD;
import fashionPOS.Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements DaoServiceCRUD<Tbcustomer> {

    @Override
    public int addData(Tbcustomer object) {
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
    public List<Tbcustomer> getAllData() {
        List<Tbcustomer> tbusers = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Tbcustomer.class);
        tbusers.addAll(criteria.list());
        return tbusers;
    }

    @Override
    public Tbcustomer getData(Tbcustomer object) {
        List<Tbcustomer> tbusers = new ArrayList<>();
        Tbcustomer isidata = new Tbcustomer();
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Tbcustomer.class);
        tbusers.addAll(criteria.list());
        for (Tbcustomer data : tbusers) {
            if (data.getCustomerId() == object.getCustomerId()) {
                isidata = data;
                break;
            }
        }
        return isidata;
    }

    @Override
    public int updateData(Tbcustomer object) {
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
    public int deleteData(Tbcustomer object) {
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
