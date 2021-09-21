package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;

    public RegControl(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
//        user.setPassword(encoder.encode(user.getPassword()));
//        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
//    public String reg(@ModelAttribute Accident accident) {
    public String reg(@ModelAttribute Post post) {
        return "reg";
    }
}