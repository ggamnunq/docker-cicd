package pharamquest.practice.domain.post.service;

import org.springframework.data.domain.Page;
import pharamquest.practice.domain.post.domain.Post;
import pharamquest.practice.domain.post.dto.PostRequestDTO;

public interface PostCommandService {
    public Post savePost(PostRequestDTO.PostWriteDto request);
    public Post editPost(PostRequestDTO.PostWriteDto request, Long postId);
    public Post deletePost(Long postId);
    Page<Post> getPosts(String category, Integer page);
}
