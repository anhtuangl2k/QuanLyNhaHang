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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anhtu
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findById", query = "SELECT m FROM Menu m WHERE m.id = :id"),
    @NamedQuery(name = "Menu.findByDish", query = "SELECT m FROM Menu m WHERE m.dish = :dish"),
    @NamedQuery(name = "Menu.findByPrice", query = "SELECT m FROM Menu m WHERE m.price = :price"),
    @NamedQuery(name = "Menu.findByUnit", query = "SELECT m FROM Menu m WHERE m.unit = :unit"),
    @NamedQuery(name = "Menu.findByStatus", query = "SELECT m FROM Menu m WHERE m.status = :status"),
    @NamedQuery(name = "Menu.findByDeteleFlag", query = "SELECT m FROM Menu m WHERE m.deteleFlag = :deteleFlag"),
    @NamedQuery(name = "Menu.findByType", query = "SELECT m FROM Menu m WHERE m.type = :type")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "Dish")
    private String dish;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private Double price;
    @Size(max = 100)
    @Column(name = "Unit")
    private String unit;
    @Size(max = 100)
    @Column(name = "Status")
    private String status;
    @Column(name = "DeteleFlag")
    private Short deteleFlag;
    @Column(name = "Type")
    private Integer type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDMenu")
    private Collection<ReceiptMenu> receiptMenuCollection;

    public Menu() {
    }

    public Menu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Short getDeteleFlag() {
        return deteleFlag;
    }

    public void setDeteleFlag(Short deteleFlag) {
        this.deteleFlag = deteleFlag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<ReceiptMenu> getReceiptMenuCollection() {
        return receiptMenuCollection;
    }

    public void setReceiptMenuCollection(Collection<ReceiptMenu> receiptMenuCollection) {
        this.receiptMenuCollection = receiptMenuCollection;
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tt.pojos.Menu[ id=" + id + " ]";
    }
    
}
