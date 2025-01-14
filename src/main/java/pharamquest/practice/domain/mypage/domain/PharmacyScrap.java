package pharamquest.practice.domain.mypage.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pharamquest.practice.common.domain.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PharmacyScrap extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private pharamquest.practice.domain.user.domain.User user;

    @ManyToOne
    @JoinColumn(name = "pharmacy_id", referencedColumnName = "id", nullable = false)
    private pharamquest.practice.domain.pharmacy.domain.Pharmacy pharmacy;
}
