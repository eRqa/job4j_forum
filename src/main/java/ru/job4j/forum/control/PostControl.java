package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {

    private final PostService posts;

    public PostControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model) {
        model.addAttribute("post", posts.findPostById(id));
        return "edit";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @GetMapping("/show")
    public String show(@RequestParam("id") Long id, Model model) {
        model.addAttribute("post", posts.findPostById(id));
        return "post";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        if (post.getId() == null) {
            posts.add(post);
        } else {
            posts.edit(post);
        }
        return "redirect:/";
    }

}
