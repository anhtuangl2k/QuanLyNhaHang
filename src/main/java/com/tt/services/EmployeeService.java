/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.services;

import com.findingcareer.pojo.Employee;
import java.util.List;

/**
 *
 * @author hp
 */
public interface EmployeeService {
    boolean addEmployee(Employee e);
    boolean updateEmployee(Employee e);
    Employee getEmployeeById(int id);
    List<Object> getListEmployee(String kw, int page);
    Object getDetailsEmployeeById(int id);
}
