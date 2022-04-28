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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anhtu
 */
@Entity
@Table(name = "receipt_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReceiptMenu.findAll", query = "SELECT r FROM ReceiptMenu r"),
    @NamedQuery(name = "ReceiptMenu.findById", query = "SELECT r FROM ReceiptMenu r WHERE r.id = :id")})
public class ReceiptMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "IDMenu", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Menu iDMenu;
    @JoinColumn(name = "IDReceipt", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Receipt iDReceipt;

    public ReceiptMenu() {
    }

    public ReceiptMenu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Menu getIDMenu() {
        return iDMenu;
    }

    public void setIDMenu(Menu iDMenu) {
        this.iDMenu = iDMenu;
    }

    public Receipt getIDReceipt() {
        return iDReceipt;
    }

    public void setIDReceipt(Receipt iDReceipt) {
        this.iDReceipt = iDReceipt;
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
        if (!(object instanceof ReceiptMenu)) {
            return false;
        }
        ReceiptMenu other = (ReceiptMenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tt.pojos.ReceiptMenu[ id=" + id + " ]";
    }
    
}
