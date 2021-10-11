package org.capstone.team3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.capstone.team3.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
