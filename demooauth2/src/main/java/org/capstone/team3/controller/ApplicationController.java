package org.capstone.team3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.capstone.team3.entity.Comment;
import org.capstone.team3.entity.Post;
import org.capstone.team3.repository.CommentRepository;
import org.capstone.team3.repository.PostRepository;

import java.util.List;

@RestController
@RequestMapping("post")
public class ApplicationController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @PostMapping
    public Post savePost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("/{id}/comment")
    public List<Comment> getPostsComment(@PathVariable(value = "id")Integer postId) {
        return commentRepository.findCommentByPostId(postId);
    }

    @PostMapping("/{id}/comment")
    public Comment saveComment(@PathVariable(value = "id")Integer postId,
                               @RequestBody Comment comment) throws Exception {
        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new Exception());
    }

}
