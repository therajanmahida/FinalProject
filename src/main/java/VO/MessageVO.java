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
    private Date MessageDate;

    @Temporal(TemporalType.TIME)
    @Column(name = "message_time",nullable = false)
    private Date MessageTime;

    @Column(name = "message",nullable = false)
    private String message;

    @OneToOne
    @JoinColumn(name = "company_id")
    private CompanyVO companyVO;

    public MessageVO() {

    }

    public MessageVO(Date messageDate, Date messageTime, String message, CompanyVO companyVO) {
        MessageDate = messageDate;
        MessageTime = messageTime;
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
        return MessageDate;
    }

    public void setMessageDate(Date messageDate) {
        MessageDate = messageDate;
    }

    public Date getMessageTime() {
        return MessageTime;
    }

    public void setMessageTime(Date messageTime) {
        MessageTime = messageTime;
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
