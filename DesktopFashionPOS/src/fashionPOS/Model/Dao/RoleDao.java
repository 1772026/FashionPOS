package fashionPOS.Model.Dao;

import fashionPOS.Model.Entity.Tbrole;
import fashionPOS.Util.DaoServiceCRUD;
import fashionPOS.Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RoleDao implements DaoServiceCRUD<Tbrole> {

    @Override
    public int addData(Tbrole object) {
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
    public List<Tbrole> getAllData() {
        List<Tbrole> tbusers=new ArrayList<>();
        Session session=HibernateUtil.getSession();
        Criteria criteria=session.createCriteria(Tbrole.class);
        tbusers.addAll(criteria.list());
        return null;
    }

    @Override
    public Tbrole getData(Tbrole object) {
        List<Tbrole> tbusers=new ArrayList<>();
        Tbrole isidata=new Tbrole();
        Session session=HibernateUtil.getSession();
        Criteria criteria=session.createCriteria(Tbrole.class);
        tbusers.addAll(criteria.list());
        for(Tbrole data: tbusers){
            if(data.getRoleId() == object.getRoleId()){
                isidata=data;
                break;
            }
        }
        return isidata;
    }

    @Override
    public int updateData(Tbrole object) {
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
    public int deleteData(Tbrole object) {
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
