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
public class WeddingHall {
    
    private UUID APK;
    private UUID APKRestaurant;
    private String Lobby;
    private String Shift;
    private int TypeShift;
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
     * @return the APKRestaurant
     */
    public UUID getAPKRestaurant() {
        return APKRestaurant;
    }

    /**
     * @param APKRestaurant the APKRestaurant to set
     */
    public void setAPKRestaurant(UUID APKRestaurant) {
        this.APKRestaurant = APKRestaurant;
    }

    /**
     * @return the Lobby
     */
    public String getLobby() {
        return Lobby;
    }

    /**
     * @param Lobby the Lobby to set
     */
    public void setLobby(String Lobby) {
        this.Lobby = Lobby;
    }

    /**
     * @return the Shift
     */
    public String getShift() {
        return Shift;
    }

    /**
     * @param Shift the Shift to set
     */
    public void setShift(String Shift) {
        this.Shift = Shift;
    }

    /**
     * @return the TypeShift
     */
    public int getTypeShift() {
        return TypeShift;
    }

    /**
     * @param TypeShift the TypeShift to set
     */
    public void setTypeShift(int TypeShift) {
        this.TypeShift = TypeShift;
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
