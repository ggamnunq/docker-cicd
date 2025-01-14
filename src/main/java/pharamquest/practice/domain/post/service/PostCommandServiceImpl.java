package pharamquest.practice.domain.post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pharamquest.practice.common.apiPayload.code.status.ErrorStatus;
import pharamquest.practice.common.apiPayload.exception.handler.CommonExceptionHandler;
import pharamquest.practice.common.enums.Status;
import pharamquest.practice.domain.post.enums.Country;
import pharamquest.practice.domain.post.domain.Post;
import pharamquest.practice.domain.post.enums.PostCategory;
import pharamquest.practice.domain.post.dto.PostRequestDTO;
import pharamquest.practice.domain.post.repository.PostRepository;

import java.util.List;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
@Slf4j
public class PostCommandServiceImpl implements PostCommandService {

    private final PostRepository postRepository;

    @Override
    public Post savePost(PostRequestDTO.PostWriteDto request) {

        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .country(Country.fromKoreanName(request.getCountry()))
                .category(PostCategory.fromKoreanName(request.getCategory()))
                .status(Status.ACTIVE)
                .views(0)
                .reports(0)
                .build();

        log.info("Saving post: {}", post.toString());

        postRepository.save(post);
        return post;
    }

    @Override
    public Post editPost(PostRequestDTO.PostWriteDto request, Long postId) {

        Post post = postRepository.findById(postId).orElseThrow(() -> new CommonExceptionHandler(ErrorStatus.POST_NOT_FOUND));
        if(post.getStatus() == Status.INACTIVE) {
            throw new CommonExceptionHandler(ErrorStatus.POST_DELETED);
        }
        post.editPost(request);
        return post;
    }

    @Override
    public Post deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new CommonExceptionHandler(ErrorStatus.POST_NOT_FOUND));
        post.updateTime();
        post.setStatus(Status.INACTIVE);
        return post;
    }

    @Override
    public Page<Post> getPosts(String category, Integer page) {
        PostCategory postCategory = PostCategory.valueOf(category);
        int size = 10;
        if (page == 1) {
            size--;
        }
        Page<Post> posts = postRepository.findPostsByCategory(postCategory, PageRequest.of(page, size));
        return posts;
    }
}
