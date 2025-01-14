package pharamquest.practice.domain.post.domain;

import jakarta.persistence.*;
import lombok.*;
import pharamquest.practice.common.domain.BaseEntity;
import pharamquest.practice.common.enums.Status;
import pharamquest.practice.domain.mypage.domain.PostScrap;
import pharamquest.practice.domain.post.dto.PostRequestDTO;
import pharamquest.practice.domain.post.enums.Country;
import pharamquest.practice.domain.post.enums.PostCategory;
import pharamquest.practice.domain.user.domain.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private PostCategory category;

    @Enumerated(EnumType.STRING)
    private Country country;

    private Integer views = 0;

    private Integer reports = 0;

    private Integer likes = 0;

    @Enumerated(EnumType.STRING)
    @Setter
    private Status status;

    // mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comments> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostScrap> postScraps = new ArrayList<>();

    public void editPost(PostRequestDTO.PostWriteDto request) {
        this.title = request.getTitle();
        this.content = request.getContent();
        this.category = PostCategory.valueOf(request.getCategory());
        this.country = Country.valueOf(request.getCountry());
        updateTime();
    }



}