package fashionPOS.Model.Dao;
/**
 * Created By Steven
 */
import fashionPOS.Model.Entity.Tbtransaction;
import fashionPOS.Util.DaoServiceCRUD;
import fashionPOS.Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransaksiDao implements DaoServiceCRUD<Tbtransaction> {

    @Override
    public int addData(Tbtransaction object) {
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
    public List<Tbtransaction> getAllData() {
        List<Tbtransaction> tbtransactions = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Tbtransaction.class);
        tbtransactions.addAll(criteria.list());
        return tbtransactions;
    }

    @Override
    public Tbtransaction getData(Tbtransaction object) {
        List<Tbtransaction> tbusers = new ArrayList<>();
        Tbtransaction isidata = new Tbtransaction();
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Tbtransaction.class);
        tbusers.addAll(criteria.list());
        for (Tbtransaction data : tbusers) {
            if (data.getTransactionId() == object.getTransactionId()) {
                isidata = data;
                break;
            }
        }
        return isidata;
    }

    @Override
    public int updateData(Tbtransaction object) {
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
    public int deleteData(Tbtransaction object) {
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
