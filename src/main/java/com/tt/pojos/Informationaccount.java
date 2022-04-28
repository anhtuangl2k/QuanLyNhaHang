/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.pojos;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anhtu
 */
@Entity
@Table(name = "informationaccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informationaccount.findAll", query = "SELECT i FROM Informationaccount i"),
    @NamedQuery(name = "Informationaccount.findById", query = "SELECT i FROM Informationaccount i WHERE i.id = :id"),
    @NamedQuery(name = "Informationaccount.findByUserName", query = "SELECT i FROM Informationaccount i WHERE i.userName = :userName"),
    @NamedQuery(name = "Informationaccount.findByAddress", query = "SELECT i FROM Informationaccount i WHERE i.address = :address"),
    @NamedQuery(name = "Informationaccount.findByPhone", query = "SELECT i FROM Informationaccount i WHERE i.phone = :phone"),
    @NamedQuery(name = "Informationaccount.findByGmail", query = "SELECT i FROM Informationaccount i WHERE i.gmail = :gmail")})
public class Informationaccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "UserName")
    private String userName;
    @Size(max = 200)
    @Column(name = "Address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "Phone")
    private String phone;
    @Size(max = 50)
    @Column(name = "Gmail")
    private String gmail;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "informationaccount")
    private Feedback feedback;
    @JoinColumn(name = "IDAccount", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Account iDAccount;

    public Informationaccount() {
    }

    public Informationaccount(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Account getIDAccount() {
        return iDAccount;
    }

    public void setIDAccount(Account iDAccount) {
        this.iDAccount = iDAccount;
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
        if (!(object instanceof Informationaccount)) {
            return false;
        }
        Informationaccount other = (Informationaccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tt.pojos.Informationaccount[ id=" + id + " ]";
    }
    
}
