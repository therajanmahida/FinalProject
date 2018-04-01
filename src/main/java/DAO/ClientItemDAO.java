package DAO;

import DAO.Global.DBOperationDAO;
import VO.ClientOrderItemsVO;

import java.util.List;

public class ClientItemDAO {

    ClientOrderItemsVO clientOrderItemsVO;
    DBOperationDAO dbOperationDAO;
    List<ClientOrderItemsVO> list;

    public ClientItemDAO() {
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<ClientOrderItemsVO> getClientOrderItemsVOList() {
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientOrderItemsVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientOrderItemsVO> getClientOrderItemsVOListByQuantity(int Quantity) {
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientOrderItemsVO where Quantity=" + Quantity);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientOrderItemsVO> getClientOrderItemsVOListByClientOrderID(int _client_order_id) {
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientOrderItemsVO where clientOrderVO.id = " + _client_order_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientOrderItemsVO> getClientOrderItemsVOListByDrugID(int _drug_id) {
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientOrderItemsVO where drugVO.id = " + _drug_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public ClientOrderItemsVO load(int _client_order_items_id) {
        dbOperationDAO.openCurrentSession();
        ClientOrderItemsVO clientOrderItemsVO = dbOperationDAO.load(ClientOrderItemsVO.class, _client_order_items_id);
        dbOperationDAO.closeCurrentSession();
        return clientOrderItemsVO;
    }

    public void deleteById(int _client_order_items_id) {
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(ClientOrderItemsVO.class, _client_order_items_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(ClientOrderItemsVO clientOrderItemsVO) {
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(clientOrderItemsVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(ClientOrderItemsVO clientOrderItemsVO, int _client_order_items_id) {
        dbOperationDAO.openCurrentSessionWithTransaction();
        clientOrderItemsVO.setId(_client_order_items_id);
        dbOperationDAO.update(clientOrderItemsVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }
}
