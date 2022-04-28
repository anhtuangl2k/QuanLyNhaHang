/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.service.impl;

import com.findingcareer.pojo.CategoryJob;
import com.tt.repository.CategoryRepository;
import com.tt.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public List<CategoryJob> getListCategory() {
        return this.categoryRepository.getListCategory();
    }

    @Override
    public CategoryJob getCategoryById(int id) {
        return this.categoryRepository.getCategoryById(id);
    }
    
}
