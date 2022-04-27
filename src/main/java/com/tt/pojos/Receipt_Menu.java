/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.pojos;

import java.util.UUID;

/**
 *
 * @author anhtu
 */
public class Receipt_Menu {
    private UUID APK;
    private UUID APKReceipt;
    private UUID APKMenu;

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
     * @return the APKReceipt
     */
    public UUID getAPKReceipt() {
        return APKReceipt;
    }

    /**
     * @param APKReceipt the APKReceipt to set
     */
    public void setAPKReceipt(UUID APKReceipt) {
        this.APKReceipt = APKReceipt;
    }

    /**
     * @return the APKMenu
     */
    public UUID getAPKMenu() {
        return APKMenu;
    }

    /**
     * @param APKMenu the APKMenu to set
     */
    public void setAPKMenu(UUID APKMenu) {
        this.APKMenu = APKMenu;
    }
    
    
}
