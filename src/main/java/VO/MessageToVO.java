package VO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message_to")
public class MessageToVO implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "message_id",nullable = false)
    private MessageVO messageVO;

    @OneToOne
    @JoinColumn(name = "user_from",nullable = false)
    private UserVO userFrom;

    @OneToOne
    @JoinColumn(name = "user_to",nullable = false)
    private UserVO userTo;

    @Column(name="isRead")
    private Integer isRead;

    public MessageToVO() {

    }

    @Override
    public String toString() {
        return "MessageToVO{" +
                "id=" + id +
                ", messageVO=" + messageVO +
                ", userFrom=" + userFrom +
                ", userTo=" + userTo +
                ", isRead=" + isRead +
                '}';
    }

    public MessageToVO(MessageVO messageVO, UserVO userFrom, UserVO userTo, Integer isRead) {
        this.messageVO = messageVO;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.isRead = isRead;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MessageVO getMessageVO() {
        return messageVO;
    }

    public void setMessageVO(MessageVO messageVO) {
        this.messageVO = messageVO;
    }

    public UserVO getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(UserVO userFrom) {
        this.userFrom = userFrom;
    }

    public UserVO getUserTo() {
        return userTo;
    }

    public void setUserTo(UserVO userTo) {
        this.userTo = userTo;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }
}
