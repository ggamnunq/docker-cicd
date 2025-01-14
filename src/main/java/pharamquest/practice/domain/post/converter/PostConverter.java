package pharamquest.practice.domain.post.converter;

import org.springframework.data.domain.Page;
import pharamquest.practice.domain.post.domain.Post;
import pharamquest.practice.domain.post.dto.PostResponseDTO;

import java.util.List;

public class PostConverter {

    public static PostResponseDTO.writePostResponse writePostResponse(Post post) {
        return PostResponseDTO.writePostResponse.builder()
                .createdAt(post.getCreatedAt())
                .build();
    }

    public static PostResponseDTO.deletePostResponse deletePostResponse(Post post) {
        return PostResponseDTO.deletePostResponse.builder()
                .id(post.getId())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    public static PostResponseDTO.postPreviewDto postPreviewDto(Post post) {
        return PostResponseDTO.postPreviewDto.builder()
                .title(post.getTitle())
                .username(post.getUser().getName())
                .likes(post.getLikes())
                .commentCount(0) // 추후에 변경
                .scrapCount(0)
                .build();
    }

    public static PostResponseDTO.postListResponse postListResponse(Page<Post> posts) {

        List<PostResponseDTO.postPreviewDto> list = posts.stream()
                .map(PostConverter::postPreviewDto).toList();

//        return PostResponseDTO.
        return null;
    }

}
