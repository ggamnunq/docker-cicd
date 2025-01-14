package pharamquest.practice.domain.mypage.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pharamquest.practice.common.domain.BaseEntity;
import pharamquest.practice.domain.medicine.domain.Medicine;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MedicineScrap extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private pharamquest.practice.domain.user.domain.User user;

    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "id", nullable = false)
    private Medicine medicine;
}
