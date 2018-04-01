package DAO;

import DAO.Global.DBOperationDAO;
import VO.FilesVO;

import java.util.List;

public class FilesDAO {
    DBOperationDAO dbOperationDAO;
    FilesVO filesVO;
    List<FilesVO> list;

    public List<FilesVO> getFilesVOList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.FilesVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public FilesVO load(int _file_id){
        dbOperationDAO.openCurrentSession();
        FilesVO filesVO = dbOperationDAO.load(FilesVO.class,_file_id);
        dbOperationDAO.closeCurrentSession();
        return filesVO;
    }

    public void deleteById(int _file_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(FilesVO.class,_file_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(FilesVO filesVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(filesVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(FilesVO filesVO,int _file_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        filesVO.setId(_file_id);
        dbOperationDAO.update(_file_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }
}
