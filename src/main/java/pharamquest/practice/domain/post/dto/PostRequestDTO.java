package pharamquest.practice.domain.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

public class PostRequestDTO {

    @Builder
    @Getter
    public static class PostWriteDto{

        @NotBlank
        private String title;

        @NotBlank
        private String content;

        @NotNull
        private String category;

        @NotNull
        private String country;

    }

}
