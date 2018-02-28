package VO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reminder")
public class ReminderVO implements Serializable{

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "reminder_date",nullable = false)
    private Date ReminderDate;

    @Temporal(TemporalType.TIME)
    @Column(name = "reminder_time",nullable = false)
    private Date ReminderTime;

    @OneToOne
    @JoinColumn(name = "reminder_from",nullable = false)
    private UserVO userVOTo;

    @OneToOne
    @JoinColumn(name = "reminder_to",nullable = false)
    private UserVO userVOFrom;

    @Column(name = "message",nullable = false)
    private String Message;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyVO companyVO;

    public ReminderVO(Date reminderDate, Date reminderTime, UserVO userVOTo, UserVO userVOFrom, String message, CompanyVO companyVO) {
        ReminderDate = reminderDate;
        ReminderTime = reminderTime;
        this.userVOTo = userVOTo;
        this.userVOFrom = userVOFrom;
        Message = message;
        this.companyVO = companyVO;
    }

    public ReminderVO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReminderDate() {
        return ReminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        ReminderDate = reminderDate;
    }

    public Date getReminderTime() {
        return ReminderTime;
    }

    public void setReminderTime(Date reminderTime) {
        ReminderTime = reminderTime;
    }

    public UserVO getUserVOTo() {
        return userVOTo;
    }

    public void setUserVOTo(UserVO userVOTo) {
        this.userVOTo = userVOTo;
    }

    public UserVO getUserVOFrom() {
        return userVOFrom;
    }

    public void setUserVOFrom(UserVO userVOFrom) {
        this.userVOFrom = userVOFrom;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }
}
