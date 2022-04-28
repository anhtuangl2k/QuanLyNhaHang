/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.service.impl;

import com.findingcareer.pojo.RatingCompany;
import com.findingcareer.pojo.User;
import com.tt.repository.EmployerRepository;
import com.tt.repository.RatingRepository;
import com.tt.repository.UserRepository;
import com.tt.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployerRepository employerRepository;
    
    @Override
    public boolean addRating(int id, int star) {
        //GET USER BY USER NAME
        User u = this.userRepository.getUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        
        RatingCompany r = new RatingCompany();
        
        r.setEmployee(u.getEmployee());
        r.setStar(star);
        r.setEmployer(this.employerRepository.getEmployerById(id));
                
        return this.ratingRepository.addRating(r);
    }

    @Override
    public RatingCompany getRatingByEmployee(int id1, int id2) {
        return this.ratingRepository.getRatingByEmployee(id1,id2);
    }

    @Override
    public Object getAverageRatingCompany(int id) {
        return this.ratingRepository.getAverageRatingCompany(id);
    }
    
}
