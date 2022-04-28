/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findingcareer.repository;

import com.findingcareer.pojo.User;
import java.util.List;

/**
 *
 * @author hp
 */
public interface UserRepository {
    User getUserByUsername(String username);
    boolean addUser(User user);
    boolean updateUserRole(User user);
}
