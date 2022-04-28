/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findingcareer.repository;
import com.findingcareer.pojo.RatingCompany;

/**
 *
 * @author hp
 */
public interface RatingRepository {
    boolean addRating(RatingCompany rating);
    RatingCompany getRatingByEmployee(int idEmployee, int idEmployer);
    Object getAverageRatingCompany(int id);
}
