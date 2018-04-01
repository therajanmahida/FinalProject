package VO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "message")
public class MessageVO implements Serializable {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "message_date",nullable = false)
    private Date messageDate;

    @Temporal(TemporalType.TIME)
    @Column(name = "message_time",nullable = false)
    private Date messageTime;

    @Column(name = "message_subject")
    private String messageSubject;

    @Column(name = "message",nullable = false,columnDefinition = "TEXT")
    private String message;

    @OneToOne
    @JoinColumn(name = "company_id")
    private CompanyVO companyVO;

    public MessageVO() {

    }

    @Override
    public String toString() {
        return "MessageVO{" +
                "id=" + id +
                ", messageDate=" + messageDate +
                ", messageTime=" + messageTime +
                ", messageSubject='" + messageSubject + '\'' +
                ", message='" + message + '\'' +
                ", companyVO=" + companyVO +
                '}';
    }

    public MessageVO(Date messageDate, Date messageTime, String messageSubject, String message, CompanyVO companyVO) {
        this.messageDate = messageDate;
        this.messageTime = messageTime;
        this.messageSubject = messageSubject;
        this.message = message;
        this.companyVO = companyVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageSubject() {
        return messageSubject;
    }

    public void setMessageSubject(String messageSubject) {
        this.messageSubject = messageSubject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }
}
