package pharamquest.practice.domain.post.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class PostResponseDTO {

    @Builder
    @Getter
    public static class writePostResponse {
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    public static class deletePostResponse {
        private Long id;
        private LocalDateTime updatedAt;
    }

    @Builder
    @Getter
    public static class postPreviewDto {
        private String title;
        private String username;
        private LocalDateTime createdAt;
        private Integer likes;
        private Integer commentCount;
        private Integer scrapCount;
        private String Category;
    }

    @Builder
    @Getter
    public static class postListResponse{
        private postPreviewDto hotPost;
        private List<postPreviewDto> newPosts;
    }

}
