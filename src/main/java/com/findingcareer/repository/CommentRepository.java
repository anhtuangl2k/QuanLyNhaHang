/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findingcareer.repository;

import java.util.List;
import com.findingcareer.pojo.Comment;

/**
 *
 * @author hp
 */
public interface CommentRepository {
    List<Comment> getCommentsByCompanyid(int id, int page);
    Comment addComment(Comment c);
}
