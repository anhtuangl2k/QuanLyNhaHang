/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.services;

import com.findingcareer.pojo.Comment;
import java.util.List;

/**
 *
 * @author hp
 */
public interface CommentService {
    List<Comment> getCommentsByCompanyid(int id, int page);
    Comment addComment(String content, int idEmployer);
}
