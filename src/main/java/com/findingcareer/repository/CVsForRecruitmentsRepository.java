/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findingcareer.repository;

import com.findingcareer.pojo.CVsForRecruitments;
import java.util.List;
import com.findingcareer.pojo.Employer;
import java.util.Date;

/**
 *
 * @author hp
 */
public interface CVsForRecruitmentsRepository {
    boolean addCV(CVsForRecruitments cv);
    boolean updateState(CVsForRecruitments cv);
    CVsForRecruitments getCVById(int id);
    List<Object> getListCVByEmployer(int idEmployer, int page); 
    long countCvsByEmployer(Employer employer);
    List<Object> staticCV(Date fromDate, Date toDate);
}
