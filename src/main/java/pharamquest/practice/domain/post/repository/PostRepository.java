package pharamquest.practice.domain.post.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pharamquest.practice.domain.post.domain.Post;
import pharamquest.practice.domain.post.enums.PostCategory;


public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select p from Post p where p.category = :category and p.status = 'ACTIVE'")
    Page<Post> findPostsByCategory(@Param("category") PostCategory category, Pageable pageable);
}
