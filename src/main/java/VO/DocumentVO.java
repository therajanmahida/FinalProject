package VO;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "document")
public class DocumentVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "user_name",nullable = false)
    private String username;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date",nullable = false)
    private Date creationDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date",nullable = false)
    private Date updateDate;

    @Column(name = "document_content", columnDefinition = "TEXT")
    private String documentContent;

    @Column(name = "screen_shot", columnDefinition = "TEXT")
    private String screen_shot;

    public DocumentVO(){

    }

    public DocumentVO(String username, Date creationDate, Date updateDate, String documentContent, String screen_shot) {
        this.username = username;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.documentContent = documentContent;
        this.screen_shot = screen_shot;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDocumentContent() {
        return documentContent;
    }

    public void setDocumentContent(String documentContent) {
        this.documentContent = documentContent;
    }

    public String getScreen_shot() {
        return screen_shot;
    }

    public void setScreen_shot(String screen_shot) {
        this.screen_shot = screen_shot;
    }

    @Override
    public String toString() {
        return "DocumentVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", documentContent='" + documentContent + '\'' +
                ", screen_shot='" + screen_shot + '\'' +
                '}';
    }

}


