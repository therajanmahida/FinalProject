package DAO.Global;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBOperationDAO extends PersistenceDAO {
    private Session currentSession;
    private Transaction currentTransaction;

    public DBOperationDAO(){

    }
    public Session openCurrentSession(){
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    public Session openCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    public void closeCurrentSession(){
        currentSession.close();
    }
    public void closeCurrentSessionWithTransaction(){
        getCurrentTransaction().commit();;
        getCurrentSession().close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        Session session = getCurrentSession();
        session  = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        Transaction transaction = getCurrentTransaction();
        transaction = currentTransaction;
    }

    public void insert(Object object){
        getCurrentSession().save(object);
    }

    public void update(Object object){
        getCurrentSession().update(object);
    }

    public void delete(String _query){
        Query query = getCurrentSession().createQuery(_query);
        query.executeUpdate();
    }

    public List getList(String _query){
        Query query = getCurrentSession().createQuery(_query);
        return query.list();
    }
    public boolean deleteById(Class<?> _class_type,int _object_id){
        Object persistence_object = getCurrentSession().load(_class_type,_object_id);
        if(persistence_object!=null){
            getCurrentSession().delete(persistence_object);
            return true;
        }
        return false;
    }










}
