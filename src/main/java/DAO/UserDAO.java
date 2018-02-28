package DAO;

import Exception.UserException.*;
import VO.UserVO;
import Validation.UserValidation;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDAO {

    public static void insert(UserVO _user_object){
        try {
            if(UserValidation.isCorrect(_user_object)){
                Session _session = PersistenceDAO.getSessionFactory().getCurrentSession();
                _session.beginTransaction();
                _session.save(_user_object);
                _session.getTransaction().commit();
            }
        } catch (UserEmptyException e) {
            e.printStackTrace();
        } catch (UserNameContainsSpace userNameContainsSpace) {
            userNameContainsSpace.printStackTrace();
        } catch (UserNameNullException e) {
            e.printStackTrace();
        } catch (UserNameInvalidLength userNameInvalidLength) {
            userNameInvalidLength.printStackTrace();
        } catch (UserNameContainsInvalidCharacter userNameContainsInvalidCharacter) {
            userNameContainsInvalidCharacter.printStackTrace();
        } catch (UserNameContainsOnlyNumber userNameContainsOnlyNumber) {
            userNameContainsOnlyNumber.printStackTrace();
        } catch (PasswordNullException e) {
            e.printStackTrace();
        } catch (PassWordContainsSpace passWordContainsSpace) {
            passWordContainsSpace.printStackTrace();
        } catch (PassWordInvalidLength passWordInvalidLength) {
            passWordInvalidLength.printStackTrace();
        }
    }
    public static List<UserVO> retrive(String _username) throws UserNotFoundException, UserNameContainsSpace, UserNameContainsOnlyNumber, UserNameContainsInvalidCharacter, UserNameNullException, UserNameInvalidLength {
        List<UserVO> _result_list = null;

            if(UserValidation.isCorrectUsername(_username)){
                Session _session = PersistenceDAO.getSessionFactory().getCurrentSession();
                _session.beginTransaction();

                Query _query = _session.createQuery("FROM User U WHERE U.username='"+_username+"'");
                _result_list  = _query.list();

                if(_result_list.size()==0){
                    throw new UserNotFoundException("Exception: User not present");
                }else
                    return _result_list;
            }

            return _result_list;

    }
    public static boolean isPresent(String _username) throws UserNameContainsSpace, UserNameContainsOnlyNumber, UserNameContainsInvalidCharacter, UserNameNullException, UserNameInvalidLength, UserNotFoundException {

        if(UserValidation.isCorrectUsername(_username)){
            Session _session = PersistenceDAO.getSessionFactory().getCurrentSession();
            _session.beginTransaction();
            Query _query = _session.createQuery("FROM User U WHERE U.username='"+_username+"'");
            List<UserVO> _result_list = _query.list();
            _session.getTransaction().commit();
            if(_result_list.size()>0){
                return true;
            }else{
                throw new UserNotFoundException("Exception: User not present");
            }
        }

        return false;

    }
    public static void update(UserVO _user_data) throws UserEmptyException, PassWordContainsSpace, UserNameInvalidLength, UserNameNullException, PasswordNullException, UserNameContainsOnlyNumber, UserNameContainsSpace, PassWordInvalidLength, UserNameContainsInvalidCharacter, UserNotFoundException {
        if(UserValidation.isCorrect(_user_data)&&isPresent(_user_data.getUsername())){
            Session _session = PersistenceDAO.getSessionFactory().getCurrentSession();
            _session.beginTransaction();




        }
    }
}
