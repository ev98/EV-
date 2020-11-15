package com.ev.blog.service;


import com.ev.blog.pojo.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentByBlogId(Long blogId);

    int saveComment(Comment comment);
}
