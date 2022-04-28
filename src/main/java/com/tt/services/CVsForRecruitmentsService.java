/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.services;

import com.findingcareer.pojo.CVsForRecruitments;
import com.findingcareer.pojo.Employer;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hp
 */
public interface CVsForRecruitmentsService {
    boolean addCV(int idRe);
    CVsForRecruitments getCVById(int id);
    boolean updateState(CVsForRecruitments cv);
    List<Object> getListCVByEmployer(int idEmployer, int page); 
    long countCvsByEmployer(Employer employer);
    List<Object> staticCV(Date fromDate, Date toDate);

}
