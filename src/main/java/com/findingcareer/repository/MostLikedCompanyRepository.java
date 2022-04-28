/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findingcareer.repository;

import com.findingcareer.pojo.MostLikedCompany;
import java.util.List;

/**
 *
 * @author hp
 */
public interface MostLikedCompanyRepository {
    boolean AddLike(MostLikedCompany like);
    MostLikedCompany getLikeByEmployeeId(int idEmployee, int idCompany);
}
