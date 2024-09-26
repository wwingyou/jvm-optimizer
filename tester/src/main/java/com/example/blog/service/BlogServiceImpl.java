package com.example.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.blog.entity.Blog;
import com.example.blog.repository.BlogRepository;

import lombok.AllArgsConstructor;

/**
 * BlogServiceImpl
 */
@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Override
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Blog createBlog(String writer, String title, String content) {
        Blog newBlog = Blog.builder()
                .writer(writer)
                .title(title)
                .content(content)
                .build();

        Blog savedBlog = blogRepository.save(newBlog);
        return savedBlog;
    }

    @Override
    public Blog updateBlog(Long id, String writer, String title, String content) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        blog.setWriter(writer);
        blog.setTitle(title);
        blog.setContent(content);

        Blog updatedBlog = blogRepository.save(blog);
        return updatedBlog;
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

}
