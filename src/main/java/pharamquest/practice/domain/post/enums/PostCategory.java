package pharamquest.practice.domain.post.enums;

import lombok.Getter;
import pharamquest.practice.common.apiPayload.code.status.ErrorStatus;
import pharamquest.practice.common.apiPayload.exception.handler.CommonExceptionHandler;

import java.util.Arrays;

@Getter
public enum PostCategory {

    FORUM("포럼"),
    PHARMACY("약국"),
    HOSPITAL("병원"),
    MEDICATION("약"),
    SYMPTOM("증상"),
    SUPPLEMENT("영양제");

    private final String koreanName;

    PostCategory(String name) {
        this.koreanName = name;
    }

    public static PostCategory fromKoreanName(String koreanName) {
        return Arrays.stream(values())
                .filter(category -> category.getKoreanName().equals(koreanName))
                .findFirst()
                .orElseThrow(() -> new CommonExceptionHandler(ErrorStatus.POST_ILLEGAL_CATEGORY));
    }


}
