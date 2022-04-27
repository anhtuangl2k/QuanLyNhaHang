/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.pojos;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;

/**
 *
 * @author anhtu
 */
public class Account {
    
    private UUID APK;
    private String UserID;
    private String Password;
    private int TypeAccount;
    private int DeleteFlag;
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
     * @return the UserID
     */
    public String getUserID() {
        return UserID;
    }

    /**
     * @param UserID the UserID to set
     */
    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the TypeAccount
     */
    public int getTypeAccount() {
        return TypeAccount;
    }

    /**
     * @param TypeAccount the TypeAccount to set
     */
    public void setTypeAccount(int TypeAccount) {
        this.TypeAccount = TypeAccount;
    }

    /**
     * @return the DeleteFlag
     */
    public int getDeleteFlag() {
        return DeleteFlag;
    }

    /**
     * @param DeleteFlag the DeleteFlag to set
     */
    public void setDeleteFlag(int DeleteFlag) {
        this.DeleteFlag = DeleteFlag;
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
