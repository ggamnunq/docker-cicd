package pharamquest.practice.domain.mypage.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pharamquest.practice.common.domain.BaseEntity;
import pharamquest.practice.domain.post.domain.Post;
import pharamquest.practice.domain.user.domain.User;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PostScrap extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}