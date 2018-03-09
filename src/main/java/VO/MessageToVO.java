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
    private UserVO UserFrom;

    @OneToOne
    @JoinColumn(name = "user_to",nullable = false)
    private UserVO UserTo;

    public MessageToVO() {

    }

    public MessageToVO(MessageVO messageVO, UserVO userFrom, UserVO userTo) {
        this.messageVO = messageVO;
        UserFrom = userFrom;
        UserTo = userTo;
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
        return UserFrom;
    }

    public void setUserFrom(UserVO userFrom) {
        UserFrom = userFrom;
    }

    public UserVO getUserTo() {
        return UserTo;
    }

    public void setUserTo(UserVO userTo) {
        UserTo = userTo;
    }
}
