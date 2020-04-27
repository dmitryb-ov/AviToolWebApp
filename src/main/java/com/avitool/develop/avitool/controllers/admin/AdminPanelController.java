package com.avitool.develop.avitool.controllers.admin;

import com.avitool.develop.avitool.models.Post;
import com.avitool.develop.avitool.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminPanelController {

    @Autowired
    private PostService postService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/admin")
    public String getAdminPage(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "admin_page";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/admin/delete")
    public String deletePost(@RequestParam("postId") Long id) {
        postService.deletePostById(id);
        return "redirect:/admin";
    }

//    @PreAuthorize("hasAnyAuthority('ADMIN')")
//    @PostMapping("/admin/delete")
//    public @ResponseBody String deletePost(@RequestParam Long id){
//        System.out.println(id);
////        postService.deletePostById(id);
//        return "redirect:/admin";
//    }

}
