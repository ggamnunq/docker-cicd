package pharamquest.practice.domain.mypage.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pharamquest.practice.common.domain.BaseEntity;
import pharamquest.practice.domain.supplements.domain.Supplements;
import pharamquest.practice.domain.user.domain.User;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SupplementScrap extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "supplement_id", referencedColumnName = "id", nullable = false)
    private Supplements supplement;
}

