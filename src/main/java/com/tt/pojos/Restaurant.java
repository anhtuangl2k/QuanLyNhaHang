/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.pojos;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author anhtu
 */
public class Restaurant {
    
    private UUID APK;
    private String Restaurant;
    private String Address;
    private String Phone;
    private String Gmail;
    private Date CreateDate;
    private String CreateUserID;
    private Date LastModifyDate;
    private String LastModifyUserID;

    /**
     * @return the APK
     */
    public UUID getAPK() {
        return APK;
    }
    
    /**
     * @param APK the APK to set
     */
    public void setAPK(UUID APK) {
        this.APK = APK;
    }

    /**
     * @return the Restaurant
     */
    public String getRestaurant() {
        return Restaurant;
    }

    /**
     * @param Restaurant the Restaurant to set
     */
    public void setRestaurant(String Restaurant) {
        this.Restaurant = Restaurant;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Phone
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * @param Phone the Phone to set
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     * @return the Gmail
     */
    public String getGmail() {
        return Gmail;
    }

    /**
     * @param Gmail the Gmail to set
     */
    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    /**
     * @return the CreateDate
     */
    public Date getCreateDate() {
        return CreateDate;
    }

    /**
     * @param CreateDate the CreateDate to set
     */
    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    /**
     * @return the CreateUserID
     */
    public String getCreateUserID() {
        return CreateUserID;
    }

    /**
     * @param CreateUserID the CreateUserID to set
     */
    public void setCreateUserID(String CreateUserID) {
        this.CreateUserID = CreateUserID;
    }

    /**
     * @return the LastModifyDate
     */
    public Date getLastModifyDate() {
        return LastModifyDate;
    }

    /**
     * @param LastModifyDate the LastModifyDate to set
     */
    public void setLastModifyDate(Date LastModifyDate) {
        this.LastModifyDate = LastModifyDate;
    }

    /**
     * @return the LastModifyUserID
     */
    public String getLastModifyUserID() {
        return LastModifyUserID;
    }

    /**
     * @param LastModifyUserID the LastModifyUserID to set
     */
    public void setLastModifyUserID(String LastModifyUserID) {
        this.LastModifyUserID = LastModifyUserID;
    }
    
    
}
