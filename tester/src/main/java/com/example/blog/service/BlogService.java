package com.example.blog.service;

import java.util.List;

import com.example.blog.entity.Blog;

/**
 * BlogService
 */
public interface BlogService {

    List<Blog> getBlogs();
    Blog getBlog(Long id);
    Blog createBlog(String writer, String title, String content);
    Blog updateBlog(Long id, String writer, String title, String content);
    void deleteBlog(Long id);

}
