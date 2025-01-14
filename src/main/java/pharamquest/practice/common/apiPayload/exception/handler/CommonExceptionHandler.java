package pharamquest.practice.common.apiPayload.exception.handler;

import pharamquest.practice.common.apiPayload.code.BaseErrorCode;
import pharamquest.practice.common.apiPayload.exception.GeneralException;

public class CommonExceptionHandler extends GeneralException {

    public CommonExceptionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
