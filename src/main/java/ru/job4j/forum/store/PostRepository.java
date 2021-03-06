package ru.job4j.forum.store;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findPostById(Long id);
}