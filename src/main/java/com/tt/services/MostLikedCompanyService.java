/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.services;

import com.findingcareer.pojo.MostLikedCompany;

/**
 *
 * @author hp
 */
public interface MostLikedCompanyService {
    boolean AddLike(int idCo);
    MostLikedCompany getLikeByEmployeeId(int idEmployee, int idCompany);
}
