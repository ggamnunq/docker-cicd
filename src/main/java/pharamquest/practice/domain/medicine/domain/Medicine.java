package pharamquest.practice.domain.medicine.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pharamquest.practice.common.domain.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Medicine extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}