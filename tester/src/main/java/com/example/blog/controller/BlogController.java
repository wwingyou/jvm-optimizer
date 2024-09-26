package com.example.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.entity.Blog;
import com.example.blog.service.BlogService;

import lombok.AllArgsConstructor;

/**
 * BlogController
 */
@RestController
@AllArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    @GetMapping("{blogId}")
    public Blog getBlogById(@PathVariable Long blogId) {
        return blogService.getBlog(blogId);
    }

    @GetMapping
    public List<Blog> getBlogs() {
        return blogService.getBlogs();
    }

    @PostMapping
    public Blog createBlog(
        @RequestParam String writer,
        @RequestParam String title,
        @RequestParam String content
    ) {
        return blogService.createBlog(writer, title, content);
    }

    @PutMapping("{blogId}")
    public Blog updateBlog(
        @PathVariable Long blogId,
        @RequestParam String writer,
        @RequestParam String title,
        @RequestParam String content
    ) {
        return blogService.updateBlog(blogId, writer, title, content);
    }

    @DeleteMapping("{blogId}")
    public void deleteBlog(@PathVariable Long blogId) {
        blogService.deleteBlog(blogId);
    }
}
