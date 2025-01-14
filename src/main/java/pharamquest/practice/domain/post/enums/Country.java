package pharamquest.practice.domain.post.enums;

import lombok.Getter;
import pharamquest.practice.common.apiPayload.code.status.ErrorStatus;
import pharamquest.practice.common.apiPayload.exception.handler.CommonExceptionHandler;

import java.util.Arrays;

@Getter
public enum Country {

    USA("미국", "US"),
    JAPAN("일본", "JP"),
    CHINA("중국", "CH")
    ;

    private final String koreanName;
    private final String shortName;

    Country(String koreanName, String shortName) {
        this.koreanName = koreanName;
        this.shortName = shortName;
    }

    public static Country fromKoreanName(String koreanName) {
        return Arrays.stream(values())
                .filter(country -> country.getKoreanName().equals(koreanName))
                .findFirst()
                .orElseThrow(() -> new CommonExceptionHandler(ErrorStatus.POST_ILLEGAL_COUNTRY));
    }

}
