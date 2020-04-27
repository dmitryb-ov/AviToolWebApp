package com.avitool.develop.avitool.controllers.admin;

import com.avitool.develop.avitool.models.Post;
import com.avitool.develop.avitool.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class AdminPanelPost {
    @Autowired
    private PostService postService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/admin/post/{post_id}")
    public String getPost(@PathVariable("post_id") Long id, Model model) {
        Optional<Post> post = postService.getPostById(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
            return "admin_post_detail";
        } else {
            return "redirect:/admin/";
        }
    }
}
