/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.service.impl;

import com.findingcareer.pojo.MostLikedRecruitment;
import com.findingcareer.pojo.Recruitment;
import com.findingcareer.pojo.User;
import com.tt.repository.RecruitmentRepository;
import com.tt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.tt.repository.MostLikedRecruitmentRepository;
import com.tt.services.MostLikedRecruitmentService;

/**
 *
 * @author hp
 */
@Service
public class MostLikedRecruitmentServiceImpl implements MostLikedRecruitmentService{
    @Autowired
    private MostLikedRecruitmentRepository likedRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecruitmentRepository recruitmentRepository; 
    
    @Override
    public boolean AddLike(int idRe) {
         //GET USER BY USER NAME
        User u = this.userRepository.getUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        
        MostLikedRecruitment m = new MostLikedRecruitment();
        
        Recruitment r = this.recruitmentRepository.getRecruitmentById(idRe);
        
        m.setRecruitment(r);
        
        m.setEmployee(u.getEmployee());
        m.setHeart(1);
        
        return this.likedRepository.AddLike(m);
    }

    @Override
    public MostLikedRecruitment getLikeByEmployeeId(int i, int i1) {
        
        return this.likedRepository.getLikeByEmployeeId(i, i1);
    }
    
}
