package Exception.UserException;

public class UserNameAlreadyTaken extends Exception {
    public UserNameAlreadyTaken(String _message) {
        super(_message);
    }
}