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
public class Menu {
    
    private UUID APK;
    private String Dish;
    private Double Price;
    private String Unit;
    private Boolean Status;
    private Boolean DeleteFlag;
    private int TypeMenu;
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
     * @return the Dish
     */
    public String getDish() {
        return Dish;
    }

    /**
     * @param Dish the Dish to set
     */
    public void setDish(String Dish) {
        this.Dish = Dish;
    }

    /**
     * @return the Price
     */
    public Double getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(Double Price) {
        this.Price = Price;
    }

    /**
     * @return the Unit
     */
    public String getUnit() {
        return Unit;
    }

    /**
     * @param Unit the Unit to set
     */
    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    /**
     * @return the Status
     */
    public Boolean getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    /**
     * @return the DeleteFlag
     */
    public Boolean getDeleteFlag() {
        return DeleteFlag;
    }

    /**
     * @param DeleteFlag the DeleteFlag to set
     */
    public void setDeleteFlag(Boolean DeleteFlag) {
        this.DeleteFlag = DeleteFlag;
    }

    /**
     * @return the TypeMenu
     */
    public int getTypeMenu() {
        return TypeMenu;
    }

    /**
     * @param TypeMenu the TypeMenu to set
     */
    public void setTypeMenu(int TypeMenu) {
        this.TypeMenu = TypeMenu;
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
