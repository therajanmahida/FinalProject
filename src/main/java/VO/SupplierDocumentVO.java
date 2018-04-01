package VO;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table
public class SupplierDocumentVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @OneToOne
    @JoinColumn
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private SupplierVO supplierVO;

    @Lob
    @Column
    private Blob document;

    public SupplierDocumentVO() {
    }

    @Override
    public String toString() {
        return "SupplierDocumentVO{" +
                "id=" + id +
                ", supplierVO=" + supplierVO +
                ", document=" + document +
                '}';
    }

    public SupplierDocumentVO(SupplierVO supplierVO, Blob document) {
        this.supplierVO = supplierVO;
        this.document = document;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SupplierVO getSupplierVO() {
        return supplierVO;
    }

    public void setSupplierVO(SupplierVO supplierVO) {
        this.supplierVO = supplierVO;
    }

    public Blob getDocument() {
        return document;
    }

    public void setDocument(Blob document) {
        this.document = document;
    }
}
