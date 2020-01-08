package fashionPOS.Model.Dao;

import fashionPOS.Model.Entity.Tbcategory;
import fashionPOS.Util.DaoServiceCRUD;
import fashionPOS.Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements DaoServiceCRUD<Tbcategory> {

    @Override
    public int addData(Tbcategory object) {
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
    public List<Tbcategory> getAllData() {
        List<Tbcategory> tbusers = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Tbcategory.class);
        tbusers.addAll(criteria.list());
        return null;
    }

    @Override
    public Tbcategory getData(Tbcategory object) {
        List<Tbcategory> tbusers = new ArrayList<>();
        Tbcategory isidata = new Tbcategory();
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Tbcategory.class);
        tbusers.addAll(criteria.list());
        for (Tbcategory data : tbusers) {
            if (data.getCategoryId() == object.getCategoryId()) {
                isidata = data;
                break;
            }
        }
        return isidata;
    }

    @Override
    public int updateData(Tbcategory object) {
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
    public int deleteData(Tbcategory object) {
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
