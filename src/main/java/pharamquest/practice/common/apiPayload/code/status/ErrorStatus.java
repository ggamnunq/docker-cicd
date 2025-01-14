package pharamquest.practice.common.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import pharamquest.practice.common.apiPayload.code.BaseErrorCode;
import pharamquest.practice.common.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // COMMON - 가장 일반적 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다"),

    // posts
    POST_ILLEGAL_COUNTRY(HttpStatus.BAD_REQUEST, "POST4001", "올바르지 않은 국가."),
    POST_ILLEGAL_CATEGORY(HttpStatus.BAD_REQUEST, "POST4002", "올바르지 않은 카테고리."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "POST4003", "게시글을 찾을 수 없습니다."),
    POST_DELETED(HttpStatus.BAD_REQUEST, "POST4004", "삭제된 게시글입니다."),

    // paramter
    PAGE_UNDER_ONE(HttpStatus.BAD_REQUEST, "PAGE4001", "페이지 번호가 1보다 작습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .code(code)
                .message(message)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
