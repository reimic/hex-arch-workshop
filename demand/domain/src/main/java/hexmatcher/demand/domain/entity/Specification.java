package hexmatcher.demand.domain.entity;

import hexmatcher.demand.domain.converter.TagIdConverter;
import hexmatcher.demand.domain.valueobject.TagId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
@ToString
public class Specification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demand_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Demand demand;
    @Column(nullable = false)
    @Convert(converter = TagIdConverter.class)
    private TagId tagId;

    public static Specification createNew(
            Demand demand,
            TagId tagId
    ){
        Specification specification = new Specification();
        specification.demand=demand;
        specification.tagId=tagId;
        return specification;
    }

}
