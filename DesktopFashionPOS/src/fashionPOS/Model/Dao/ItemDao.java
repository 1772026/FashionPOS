package fashionPOS.Model.Dao;

import fashionPOS.Model.Entity.Tbitem;
import fashionPOS.Util.DaoServiceCRUD;
import fashionPOS.Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ItemDao implements DaoServiceCRUD<Tbitem> {

    @Override
    public int addData(Tbitem object) {
        int result=0;
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(object);
            transaction.commit();
            result=1;
        }catch (HibernateException e){
            transaction.rollback();
        }
        return result;
    }

    @Override
    public List<Tbitem> getAllData() {
        List<Tbitem> tbitems=new ArrayList<>();
        Session session=HibernateUtil.getSession();
        Criteria criteria=session.createCriteria(Tbitem.class);
        tbitems.addAll(criteria.list());
        return tbitems;
    }

    @Override
    public Tbitem getData(Tbitem object) {
        List<Tbitem> tbusers=new ArrayList<>();
        Tbitem isidata=new Tbitem();
        Session session=HibernateUtil.getSession();
        Criteria criteria=session.createCriteria(Tbitem.class);
        tbusers.addAll(criteria.list());
        for(Tbitem data: tbusers){
            if(data.getItemId()==object.getItemId()){
                isidata=data;
                break;
            }
        }
        return isidata;
    }

    @Override
    public int updateData(Tbitem object) {
        int result=0;
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(object);
            transaction.commit();
            result=1;
        }catch (HibernateException e){
            transaction.rollback();
        }
        return result;
    }

    @Override
    public int deleteData(Tbitem object) {
        int result=0;
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.delete(object);
            transaction.commit();
            result=1;
        }catch (HibernateException e){
            transaction.rollback();
        }
        return result;
    }
}
