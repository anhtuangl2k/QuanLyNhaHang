/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.services;

import com.findingcareer.pojo.RatingCompany;

/**
 *
 * @author hp
 */
public interface RatingService {
    boolean addRating(int id, int star);
    RatingCompany getRatingByEmployee(int idEmployee, int idEmployer);
    Object getAverageRatingCompany(int id);
}
