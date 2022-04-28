/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.findingcareer.pojo.Employer;
import com.findingcareer.pojo.User;
import com.tt.repository.EmployerRepository;
import com.tt.repository.UserRepository;
import com.tt.services.EmployerService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addEmployer(Employer e) {
        // LOAD AVATAR AND CV UP TO CLOUDINARY
        String img = null;
        String logo = null;

        try {
            Map rlogo = this.cloudinary.uploader().upload(e.getFilelogo().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));

            Map rimg = this.cloudinary.uploader().upload(e.getFileComimg().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));

            //GET IMAGE'S URL AND ADD TO DATABASE
            img = (String) rimg.get("secure_url");
            logo = (String) rlogo.get("secure_url");

        } catch (IOException ex) {
            System.err.println("Failure: " + ex.getMessage());
        }
        //SET AVARTAR
        e.setLogo(logo);
        e.setCompanyImg(img);

        //GET USER BY USER NAME
        User u = this.userRepository.getUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        // SET NEW ROLE FOR USER
        u.setUserRole("ROLE_EMPLOYER");
        // SET ID USER FOR EMPLOYER
        e.setUser(u);
        // CHANGE USER ROLE
        this.userRepository.updateUserRole(u);

        e.setActive(false);

        return this.employerRepository.addEmployer(e);
    }

    @Override
    public Employer getEmployerById(int id) {
        return this.employerRepository.getEmployerById(id);
    }

    @Override
    public boolean updateEmployer(Employer e) {
        String img = null;
        String logo = null;

        User u = this.userRepository.getUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());

        try {
            if (e.getFileComimg().getBytes().length != 0
                    && e.getFilelogo().getBytes().length != 0) {
                try {
                    Map rlogo = this.cloudinary.uploader().upload(e.getFilelogo().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));

                    Map rimg = this.cloudinary.uploader().upload(e.getFileComimg().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));

                    //GET IMAGE'S URL AND ADD TO DATABASE
                    img = (String) rimg.get("secure_url");
                    logo = (String) rlogo.get("secure_url");

                } catch (IOException ex) {
                    System.err.println("Failure: " + ex.getMessage());
                }
            }
            if (e.getFileComimg().getBytes().length != 0
                    && e.getFilelogo().getBytes().length == 0) {
                Map rimg = this.cloudinary.uploader().upload(e.getFileComimg().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));

                //GET IMAGE'S URL AND ADD TO DATABASE
                img = (String) rimg.get("secure_url");
                logo = u.getEmployer().getLogo();
            }
            if (e.getFileComimg().getBytes().length == 0
                    && e.getFilelogo().getBytes().length != 0) {
                Map rlogo = this.cloudinary.uploader().upload(e.getFilelogo().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));

                //GET IMAGE'S URL AND ADD TO DATABASE
                logo = (String) rlogo.get("secure_url");
                img = u.getEmployee().getAvatarUrl();

            }
            if (e.getFileComimg().getBytes().length == 0
                    && e.getFilelogo().getBytes().length == 0) {

                img = u.getEmployer().getCompanyImg();
                logo = u.getEmployer().getLogo();
            }
        } catch (IOException ex) {
            Logger.getLogger(EmployeeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        //UPDATE AVARTAR
        e.setCompanyImg(img);
        e.setLogo(logo);

        e.setIdEmployer(u.getEmployer().getIdEmployer());

        return this.employerRepository.updateEmployer(e);
    }

    @Override
    public List<Object[]> getListEmployerByName(String string, int page, int state) {
        return this.employerRepository.getListEmployerByName(string, page, state);
    }

    @Override
    public List<Object[]> getFavoriteCompanies() {
        return this.employerRepository.getFavoriteCompanies();
    }

    @Override
    public long countEmployer() {
        return this.employerRepository.countEmployer();
    }

    @Override
    public boolean updateEmployerState(Employer emplr) {
        return this.employerRepository.updateEmployerState(emplr);
    }

}
