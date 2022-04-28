/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.findingcareer.pojo.Employee;
import com.findingcareer.pojo.User;
import com.tt.repository.EmployeeRepository;
import com.tt.repository.UserRepository;
import com.tt.services.EmployeeService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

/**
 *
 * @author hp
 */
@Controller
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addEmployee(Employee employee) {
        // LOAD AVATAR AND CV UP TO CLOUDINARY
        String img = null;
        String cv = null;

        try {
            Map rAva = this.cloudinary.uploader().upload(employee.getFileAva().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));

            Map rCV = this.cloudinary.uploader().upload(employee.getFileCV().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));

            //GET IMAGE'S URL AND ADD TO DATABASE
            img = (String) rAva.get("secure_url");
            cv = (String) rCV.get("secure_url");

        } catch (IOException ex) {
            System.err.println("Failure: " + ex.getMessage());
        }
        //SET AVARTAR
        employee.setAvatarUrl(img);
        employee.setCv(cv);

        //GET USER BY USER NAME
        User u = this.userRepository.getUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        // SET NEW ROLE FOR USER
        u.setUserRole("ROLE_EMPLOYEE");
        // SET ID USER FOR EMPLOYER
        employee.setUser(u);
        //UPDATE ROLE IN USER
        this.userRepository.updateUserRole(u);

        return this.employeeRepository.addEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee e) {
        //GET USER BY USER NAME
        User u = this.userRepository.getUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());

        String img = null;
        String cv = null;

        try {
            if (e.getFileAva().getBytes().length != 0
                    && e.getFileCV().getBytes().length != 0) {
                try {
                    Map rAva = this.cloudinary.uploader().upload(e.getFileAva().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));

                    Map rCV = this.cloudinary.uploader().upload(e.getFileCV().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));

                    //GET IMAGE'S URL AND ADD TO DATABASE
                    img = (String) rAva.get("secure_url");
                    cv = (String) rCV.get("secure_url");

                } catch (IOException ex) {
                    System.err.println("Failure: " + ex.getMessage());
                }
            }
            if (e.getFileAva().getBytes().length != 0
                    && e.getFileCV().getBytes().length == 0) {
                Map rAva = this.cloudinary.uploader().upload(e.getFileAva().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));

                //GET IMAGE'S URL AND ADD TO DATABASE
                img = (String) rAva.get("secure_url");
                cv = u.getEmployee().getCv();
            }
            if (e.getFileAva().getBytes().length == 0
                    && e.getFileCV().getBytes().length != 0) {
                Map rCV = this.cloudinary.uploader().upload(e.getFileCV().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));

                //GET IMAGE'S URL AND ADD TO DATABASE
                cv = (String) rCV.get("secure_url");
                img = u.getEmployee().getAvatarUrl();
                
            } if (e.getFileAva().getBytes().length == 0
                    && e.getFileCV().getBytes().length == 0){
                
                img = u.getEmployee().getAvatarUrl();
                cv = u.getEmployee().getCv();
            }
        } catch (IOException ex) {
            Logger.getLogger(EmployeeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //UPDATE AVARTAR
        e.setAvatarUrl(img);
        e.setCv(cv);

        e.setIdEmployee(u.getEmployee().getIdEmployee());

        return this.employeeRepository.updateEmployee(e);
    }

    @Override
    public Employee getEmployeeById(int i) {
        return this.employeeRepository.getEmployeeById(i);
    }

    @Override
    public List<Object> getListEmployee(String string, int i) {
        return this.employeeRepository.getListEmployee(string, i);
    }

    @Override
    public Object getDetailsEmployeeById(int id) {
        return this.employeeRepository.getDetailsEmployeeById(id);
    }
}
