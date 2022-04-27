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
public class FeedBack {
    
    private UUID APK;
    private UUID APKWeddingHall;
    private String UserID;
    private String Comment;
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
     * @return the APKWeddingHall
     */
    public UUID getAPKWeddingHall() {
        return APKWeddingHall;
    }

    /**
     * @param APKWeddingHall the APKWeddingHall to set
     */
    public void setAPKWeddingHall(UUID APKWeddingHall) {
        this.APKWeddingHall = APKWeddingHall;
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
     * @return the Comment
     */
    public String getComment() {
        return Comment;
    }

    /**
     * @param Comment the Comment to set
     */
    public void setComment(String Comment) {
        this.Comment = Comment;
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
