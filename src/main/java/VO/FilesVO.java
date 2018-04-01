package VO;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "files")
public class FilesVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @OneToOne
    @JoinColumn
    private UserVO userVO;

    @Column
    private Blob file;

    public FilesVO() {
    }

    public FilesVO(UserVO userVO, Blob file) {
        this.userVO = userVO;
        this.file = file;
    }

    @Override
    public String toString() {
        return "FilesVO{" +
                "id=" + id +
                ", userVO=" + userVO +
                ", file=" + file +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }
}
