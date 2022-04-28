/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.pojos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anhtu
 */
@Entity
@Table(name = "weddinghall")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Weddinghall.findAll", query = "SELECT w FROM Weddinghall w"),
    @NamedQuery(name = "Weddinghall.findById", query = "SELECT w FROM Weddinghall w WHERE w.id = :id"),
    @NamedQuery(name = "Weddinghall.findByLobby", query = "SELECT w FROM Weddinghall w WHERE w.lobby = :lobby"),
    @NamedQuery(name = "Weddinghall.findByQuantity", query = "SELECT w FROM Weddinghall w WHERE w.quantity = :quantity"),
    @NamedQuery(name = "Weddinghall.findByShift", query = "SELECT w FROM Weddinghall w WHERE w.shift = :shift"),
    @NamedQuery(name = "Weddinghall.findByDeleteFlag", query = "SELECT w FROM Weddinghall w WHERE w.deleteFlag = :deleteFlag")})
public class Weddinghall implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 45)
    @Column(name = "Lobby")
    private String lobby;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Quantity")
    private Double quantity;
    @Size(max = 50)
    @Column(name = "Shift")
    private String shift;
    @Column(name = "DeleteFlag")
    private Short deleteFlag;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "weddinghall")
    private Feedback feedback;
    @JoinColumn(name = "IDRestaurant", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Restaurant iDRestaurant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDWeddingHall")
    private Collection<Receipt> receiptCollection;

    public Weddinghall() {
    }

    public Weddinghall(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLobby() {
        return lobby;
    }

    public void setLobby(String lobby) {
        this.lobby = lobby;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Restaurant getIDRestaurant() {
        return iDRestaurant;
    }

    public void setIDRestaurant(Restaurant iDRestaurant) {
        this.iDRestaurant = iDRestaurant;
    }

    @XmlTransient
    public Collection<Receipt> getReceiptCollection() {
        return receiptCollection;
    }

    public void setReceiptCollection(Collection<Receipt> receiptCollection) {
        this.receiptCollection = receiptCollection;
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
        if (!(object instanceof Weddinghall)) {
            return false;
        }
        Weddinghall other = (Weddinghall) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tt.pojos.Weddinghall[ id=" + id + " ]";
    }
    
}
