package com.avitool.develop.avitool.service;

import com.avitool.develop.avitool.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Optional<Post> getPostById(Long id);

    Post createPost(Post post);

    List<Post> getAllPosts();

    void deletePostById(Long id);
}
