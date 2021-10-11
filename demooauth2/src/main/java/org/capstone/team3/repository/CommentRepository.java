package org.capstone.team3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.capstone.team3.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findCommentByPostId(Integer postId);

}
