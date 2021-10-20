package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.store.PostRepository;

import java.util.*;

@Service
public class PostService {

    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public void add(Post post) {
        post.setCreated(Calendar.getInstance());
        posts.save(post);
    }

    public void edit(Post post) {
        posts.save(post);
    }

    public Post findPostById(Long id) {
        return posts.findPostById(id);
    }

}