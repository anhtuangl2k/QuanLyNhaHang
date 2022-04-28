/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.services;

import com.findingcareer.pojo.Recruitment;
import java.util.List;

/**
 *
 * @author hp
 */
public interface RecruitmentService {
    List<Object> getListRecruitmentByCondition(String kw, int page);
    List<Recruitment> getAmountRecruitmentByCompany(int id, int index);
    Recruitment getRecruitmentById(int id);
    boolean updateRecruitment(Recruitment r);
    boolean addRecruitment(Recruitment r);
    boolean deleteRecruitment(int id);
    long countRes();
    List<Object[]> getFavoriteRecruitments();
}
