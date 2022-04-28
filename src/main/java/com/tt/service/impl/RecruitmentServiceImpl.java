/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.service.impl;

import com.findingcareer.pojo.CategoryJob;
import com.findingcareer.pojo.Recruitment;
import com.findingcareer.pojo.User;
import com.tt.repository.CategoryRepository;
import com.tt.repository.RecruitmentRepository;
import com.tt.repository.UserRepository;
import com.tt.services.RecruitmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    @Autowired
    private RecruitmentRepository recruitmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Object> getListRecruitmentByCondition(String kw, int page) {
        return this.recruitmentRepository.getListRecruitmentByCondition(kw, page);
    }

    @Override
    public Recruitment getRecruitmentById(int id) {
        return this.recruitmentRepository.getRecruitmentById(id);
    }

    @Override
    public boolean updateRecruitment(Recruitment r) {
        CategoryJob c = this.categoryRepository.
                getCategoryById(r.getCategoryJob().getIdCategory());
        
        r.setCategoryJob(c);
        
        User u = this.userRepository.getUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());

        r.setEmployer(u.getEmployer());
        
        return this.recruitmentRepository.updateRecruitment(r);
    }

    @Override
    public boolean addRecruitment(Recruitment r) {
        CategoryJob c = this.categoryRepository.
                getCategoryById(r.getCategoryJob().getIdCategory());
        
        r.setCategoryJob(c);
        
        User u = this.userRepository.getUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());

        r.setEmployer(u.getEmployer());
        
        return this.recruitmentRepository.addRecruitment(r);
    }

    @Override
    public boolean deleteRecruitment(int id) {
        Recruitment r = this.recruitmentRepository.getRecruitmentById(id);

        return this.recruitmentRepository.deleteRecruitment(r);
    }

    @Override
    public List<Recruitment> getAmountRecruitmentByCompany(int id, int index) {
        return this.recruitmentRepository.getAmountRecruitmentByCompany(id, index);
    }

    @Override
    public long countRes() {
        return this.recruitmentRepository.countRes();
    }

    @Override
    public List<Object[]> getFavoriteRecruitments() {
        return this.recruitmentRepository.getFavoriteRecruitments();
    }

}
