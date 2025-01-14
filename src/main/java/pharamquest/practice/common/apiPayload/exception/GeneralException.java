package pharamquest.practice.common.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pharamquest.practice.common.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{

    private pharamquest.practice.common.apiPayload.code.BaseErrorCode code;

    public ErrorReasonDTO getErrorReason(){
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }

}
