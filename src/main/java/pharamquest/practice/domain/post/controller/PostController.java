package pharamquest.practice.domain.post.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pharamquest.practice.common.apiPayload.ApiResponse;
import pharamquest.practice.common.apiPayload.code.status.SuccessStatus;
import pharamquest.practice.common.validation.annotaions.PageValid;
import pharamquest.practice.domain.post.converter.PostConverter;
import pharamquest.practice.domain.post.domain.Post;
import pharamquest.practice.domain.post.dto.PostRequestDTO;
import pharamquest.practice.domain.post.dto.PostResponseDTO;
import pharamquest.practice.domain.post.service.PostCommandService;

@RestController
@RequestMapping("/community")
@RequiredArgsConstructor
public class PostController {

    private final PostCommandService postCommandService;

    @PostMapping("/posts")
    @Operation(summary = "게시글 작성 api", description = "게시글 작성하는 api입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "POST200", description = "게시글 작성 성공!"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "POST4001", description = "올바르지 않은 국가", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<PostResponseDTO.writePostResponse> writePost(@RequestBody @Valid PostRequestDTO.PostWriteDto request) {
        Post post = postCommandService.savePost(request);
        return ApiResponse.of(SuccessStatus.POST_WRITE, PostConverter.writePostResponse(post));
    }

    // 글 수정
    @PatchMapping("/posts")
    public ApiResponse<PostResponseDTO.writePostResponse> editPost(@RequestBody @Valid PostRequestDTO.PostWriteDto request, @RequestParam("postId") Long postId) {
        Post post = postCommandService.editPost(request, postId);
        return ApiResponse.of(SuccessStatus.POST_WRITE, PostConverter.writePostResponse(post));
    }

    // 글 삭제
    @DeleteMapping("/posts")
    public ApiResponse<PostResponseDTO.deletePostResponse> deletePost(@RequestParam("postId") Long postId) {
        Post post = postCommandService.deletePost(postId);
        return ApiResponse.of(SuccessStatus.POST_DELETE, PostConverter.deletePostResponse(post));
    }

    // 게시글 리스트 조회
    @GetMapping("/posts/list")
    public ApiResponse<PostResponseDTO.postListResponse> listPosts(@RequestParam("category") String category, @PageValid Integer page) {
        Page<Post> posts = postCommandService.getPosts(category, page);
//        return ApiResponse.of(SuccessStatus.POST_LIST, PostConverter.)
        return null;
    }


}
