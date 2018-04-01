package DAO;

import DAO.Global.DBOperationDAO;
import VO.DocumentVO;

import java.util.Date;
import java.util.List;

public class DocumentDAO {
    DocumentVO documentVO;
    List<DocumentVO> list;
    DBOperationDAO dbOperationDAO;

    public DocumentDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<DocumentVO> getDocumentVOList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.DocumentVO");
        dbOperationDAO.closeCurrentSession();;
        return list;
    }

    public List<DocumentVO> getDocumentVOListByUserName(String username){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.DocumentVO where username='"+username+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<DocumentVO> getDocumentVOByID(int _id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.DocumentVO where id="+_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<DocumentVO> getDocumentDAOListByUserNameAndCreationDate(String username , Date time){
        dbOperationDAO.openCurrentSession();
        org.hibernate.Query query = dbOperationDAO.getCurrentSession().createQuery("from VO.DocumentVO where username = "+username+" creationDate=:date");
        query.setTimestamp("date",time);
        list = query.list();
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public DocumentVO load(int _document_id){
        dbOperationDAO.openCurrentSession();
        DocumentVO documentVO = dbOperationDAO.load(DocumentVO.class,_document_id);
        dbOperationDAO.closeCurrentSession();
        return documentVO;
    }

    public void deleteById(int _document_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(DocumentVO.class,_document_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(DocumentVO documentVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(documentVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(DocumentVO documentVO,int _document_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        documentVO.setId(_document_id);
        dbOperationDAO.update(documentVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }
}
