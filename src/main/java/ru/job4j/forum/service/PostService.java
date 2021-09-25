package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {

    private final Map<Integer, Post> posts = new HashMap<>();
    private final AtomicInteger size = new AtomicInteger(1);

    public PostService() {
        Post p = Post.of("Продаю машину ладу 01");
        p.setDesc("Тачло в отличном состоянии. Салон кожа рожа все дела. " +
                "Все что нужно дует светит моргает. Одной рукой рулю, другой слезы счастья вытираю. " +
                "Наверху и внизу панорама");
        p.setCreated(new GregorianCalendar(2021, Calendar.MAY , 21));
        p.setId(1);
        posts.put(1, p);
    }

    public List<Post> getAll() {
        return new ArrayList<>(posts.values());
    }

    public void add(Post post) {
        post.setId(size.incrementAndGet());
        post.setCreated(Calendar.getInstance());
        posts.put(post.getId(), post);
    }

    public void edit(Post post) {
        posts.put(post.getId(), post);
    }

    public Post findPostById(int id) {
        return posts.get(id);
    }

}