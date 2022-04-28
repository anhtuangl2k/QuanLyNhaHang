/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.service.impl;

import com.findingcareer.pojo.Comment;
import com.findingcareer.pojo.User;
import com.tt.repository.CommentRepository;
import com.tt.repository.EmployerRepository;
import com.tt.repository.UserRepository;
import com.tt.services.CommentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployerRepository employerRepository;
    
    @Override
    public List<Comment> getCommentsByCompanyid(int id, int page) {
        return this.commentRepository.getCommentsByCompanyid(id, page);
    }

    @Override
    public Comment addComment(String content, int id) {
        //GET USER BY USER NAME
        User u = this.userRepository.getUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        
        Comment c = new Comment();
        
        c.setContent(content);
        c.setEmployer(this.employerRepository.getEmployerById(id));
        c.setEmployee(u.getEmployee());
        c.setCreateDate(new Date());
        
        return this.commentRepository.addComment(c);
    }
    
}
