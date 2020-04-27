package com.avitool.develop.avitool.service;

import com.avitool.develop.avitool.models.Post;
import com.avitool.develop.avitool.repositories.PostRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private static Logger logger = Logger.getLogger(PostServiceImpl.class.getSimpleName());
    @Autowired
    private PostRepository postRepository;

    @Override
    public Optional<Post> getPostById(Long id) {
        logger.info("Get post by id: " + id);
        return postRepository.findById(id);
    }

    @Override
    public Post createPost(Post post) {
        logger.info("Create post: " + post.getTitle());
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        logger.info("Get all posts");
        return postRepository.findAll();
    }

    @Override
    public void deletePostById(Long id) {
        logger.info("Delete post by id: " + id);
        postRepository.deleteById(id);
    }
}
