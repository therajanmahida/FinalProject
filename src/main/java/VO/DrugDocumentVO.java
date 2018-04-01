package VO;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table
public class DrugDocumentVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn
    private DrugVO drugVO;

    @Lob
    @Column
    private Blob document;

    public DrugDocumentVO(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DrugVO getDrugVO() {
        return drugVO;
    }

    public void setDrugVO(DrugVO drugVO) {
        this.drugVO = drugVO;
    }

    public Blob getDocument() {
        return document;
    }

    public void setDocument(Blob document) {
        this.document = document;
    }

    public DrugDocumentVO(DrugVO drugVO, Blob document) {
        this.drugVO = drugVO;
        this.document = document;
    }

    @Override
    public String toString() {
        return "DrugDocumentVO{" +
                "id=" + id +
                ", drugVO=" + drugVO +
                ", document=" + document +
                '}';
    }
}
