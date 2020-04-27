package com.avitool.develop.avitool.controllers.admin;

import com.avitool.develop.avitool.converter.TagToTagArrayConverter;
import com.avitool.develop.avitool.models.Post;
import com.avitool.develop.avitool.models.Tag;
import com.avitool.develop.avitool.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminPanelCreatePost {
    @Autowired
    private PostService postService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/admin/create")
    public String getCreatePage() {
        return "admin_create_post";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/admin/create")
    public String sendPost(
            @RequestParam("postTitle") String title,
            @RequestParam("postDescription") String description,
            @RequestParam("postContent") String content,
            @RequestParam("tag") String tag) {
        Post post = new Post(title, description, content);
        TagToTagArrayConverter tagToTagArrayConverter = new TagToTagArrayConverter();
        String[] tags = tagToTagArrayConverter.convert(tag);
        if (tags != null) {
            for (String s : tags) {
                post.getTags().add(new Tag(s));
                new Tag(s).getPosts().add(post);
            }
            postService.createPost(post);
        }
        return "redirect:/admin/";
    }
}
