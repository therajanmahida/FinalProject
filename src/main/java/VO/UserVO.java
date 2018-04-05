package VO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserVO  implements Serializable{

    public enum UserLevel{HEAD,SENIOR,JUNIOR};
    public enum AccountStatus{ACTIVE,BLOCKED};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "username",nullable = false,unique = true)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_level",nullable = false)
    private UserLevel userLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status",nullable = false)
    private AccountStatus accountStatus;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private EmployeeVO employeeVO;

    public UserVO(){

    }

    public UserVO(String username, String password, UserLevel userLevel, AccountStatus accountStatus, EmployeeVO employeeVO) {
        this.username = username;
        this.password = password;
        this.userLevel = userLevel;
        this.accountStatus = accountStatus;
        this.employeeVO = employeeVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLevel getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(UserLevel userLevel) {
        this.userLevel = userLevel;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public EmployeeVO getEmployeeVO() {
        return employeeVO;
    }

    public void setEmployeeVO(EmployeeVO employeeVO) {
        this.employeeVO = employeeVO;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userLevel=" + userLevel +
                ", accountStatus=" + accountStatus +
                ", employeeVO=" + employeeVO +
                '}';
    }
}
