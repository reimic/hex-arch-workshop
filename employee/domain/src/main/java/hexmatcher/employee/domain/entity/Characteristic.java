package hexmatcher.employee.domain.entity;

import hexmatcher.employee.domain.converter.CharacteristicIdConverter;
import hexmatcher.employee.domain.converter.TagIdConverter;
import hexmatcher.employee.domain.valueobject.CharacteristicId;
import hexmatcher.employee.domain.valueobject.TagId;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Characteristic {
    @Id
    @Convert(converter = CharacteristicIdConverter.class)
    private CharacteristicId characteristicId;

    @ManyToOne
    private Employee employee;

    @Convert(converter = TagIdConverter.class)
    private TagId tagId;

    public static Characteristic createNew(
            Employee employee,
            TagId tagid
    ){
        final var characteristic = new Characteristic();
        characteristic.characteristicId = new CharacteristicId(UUID.randomUUID());
        characteristic.employee = employee;
        characteristic.tagId = tagid;
        return characteristic;
    }
}
