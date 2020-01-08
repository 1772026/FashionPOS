package fashionPOS.Model.Dao;

import fashionPOS.Model.Entity.Tbsizestock;
import fashionPOS.Util.DaoServiceCRUD;
import fashionPOS.Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SizeStockDao implements DaoServiceCRUD<Tbsizestock> {

    @Override
    public int addData(Tbsizestock object) {
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
    public List<Tbsizestock> getAllData() {
        List<Tbsizestock> tbusers = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Tbsizestock.class);
        tbusers.addAll(criteria.list());
        return tbusers;
    }

    @Override
    public Tbsizestock getData(Tbsizestock object) {
        List<Tbsizestock> tbusers = new ArrayList<>();
        Tbsizestock isidata = new Tbsizestock();
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Tbsizestock.class);
        tbusers.addAll(criteria.list());
        for (Tbsizestock data : tbusers) {
            if (data.getTbitemByTbitemItemId() == object.getTbitemByTbitemItemId()) {
                isidata = data;
                break;
            }
        }
        return isidata;
    }

    @Override
    public int updateData(Tbsizestock object) {
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
    public int deleteData(Tbsizestock object) {
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
