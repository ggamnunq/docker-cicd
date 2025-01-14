package pharamquest.practice.common.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import pharamquest.practice.common.apiPayload.code.BaseCode;
import pharamquest.practice.common.apiPayload.code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    //일반적 응답
    _OK(HttpStatus.OK, "COMMON200", "성공입니다."),

    // post
    POST_WRITE(HttpStatus.OK, "POST200", "글이 성공적으로 작성되었습니다."),
    POST_EDIT(HttpStatus.OK, "POST201", "글이 성공적으로 수정되었습니다."),
    POST_DELETE(HttpStatus.OK, "POST202", "글이 성공적으로 삭제되었습니다."),
    POST_LIST(HttpStatus.OK, "POST203", "글을 성공적으로 불러왔습니다.")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}
