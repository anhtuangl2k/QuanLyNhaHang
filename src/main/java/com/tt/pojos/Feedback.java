/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anhtu
 */
@Entity
@Table(name = "feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f"),
    @NamedQuery(name = "Feedback.findById", query = "SELECT f FROM Feedback f WHERE f.id = :id"),
    @NamedQuery(name = "Feedback.findByIDWeddingHall", query = "SELECT f FROM Feedback f WHERE f.iDWeddingHall = :iDWeddingHall"),
    @NamedQuery(name = "Feedback.findByIDInformationAccount", query = "SELECT f FROM Feedback f WHERE f.iDInformationAccount = :iDInformationAccount"),
    @NamedQuery(name = "Feedback.findByComment", query = "SELECT f FROM Feedback f WHERE f.comment = :comment")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDWeddingHall")
    private int iDWeddingHall;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDInformationAccount")
    private int iDInformationAccount;
    @Size(max = 1000)
    @Column(name = "Comment")
    private String comment;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Informationaccount informationaccount;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Weddinghall weddinghall;

    public Feedback() {
    }

    public Feedback(Integer id) {
        this.id = id;
    }

    public Feedback(Integer id, int iDWeddingHall, int iDInformationAccount) {
        this.id = id;
        this.iDWeddingHall = iDWeddingHall;
        this.iDInformationAccount = iDInformationAccount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIDWeddingHall() {
        return iDWeddingHall;
    }

    public void setIDWeddingHall(int iDWeddingHall) {
        this.iDWeddingHall = iDWeddingHall;
    }

    public int getIDInformationAccount() {
        return iDInformationAccount;
    }

    public void setIDInformationAccount(int iDInformationAccount) {
        this.iDInformationAccount = iDInformationAccount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Informationaccount getInformationaccount() {
        return informationaccount;
    }

    public void setInformationaccount(Informationaccount informationaccount) {
        this.informationaccount = informationaccount;
    }

    public Weddinghall getWeddinghall() {
        return weddinghall;
    }

    public void setWeddinghall(Weddinghall weddinghall) {
        this.weddinghall = weddinghall;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tt.pojos.Feedback[ id=" + id + " ]";
    }
    
}
