package Validation;

import Exception.UserException.*;
import VO.UserVO;

public class UserValidation {
    public static boolean isCorrect(UserVO _user_data) throws UserEmptyException, UserNameContainsSpace, UserNameNullException, UserNameInvalidLength, UserNameContainsInvalidCharacter, UserNameContainsOnlyNumber, PasswordNullException, PassWordContainsSpace, PassWordInvalidLength {
        return isCorrectUsername(_user_data.getUsername())&&isCorrectPassWord(_user_data.getPassword());
    }
    public static boolean isCorrectPassWord(String _password) throws PasswordNullException, PassWordContainsSpace, PassWordInvalidLength {
        if(_password==null)
            throw new PasswordNullException("Exception: Password null");
        if(_password.contains(" "))
            throw new PassWordContainsSpace("Exception: Password conatins space");
        if(!_password.matches(("(.{8,})")))
            throw new PassWordInvalidLength("Exception Password invalid length");
        else
            return true;
    }
    public static boolean isCorrectUsername(String _username) throws UserNameNullException, UserNameContainsSpace, UserNameContainsOnlyNumber, UserNameContainsInvalidCharacter, UserNameInvalidLength {
        if(_username==null)
            throw new UserNameNullException("Exception: Username null");
        if(_username.contains(" "))
            throw new UserNameContainsSpace("Exception Username contains space");
        if(_username.matches("(\\d)+"))
            throw new UserNameContainsOnlyNumber("Exception: Username contains only number");
        if(!_username.matches("(\\w|\\d)+"))
            throw new UserNameContainsInvalidCharacter("Exception: Username contains invalid character");
        if(!_username.matches("(\\w|\\d){8,}"))
            throw new UserNameInvalidLength("Exception: Username should be of length more than 8");
        else
            return true;
    }
    private void trimData(UserVO _data){
        _data.setPassword(_data.getUsername().trim());
        _data.setPassword(_data.getUsername().trim());
    }

}
