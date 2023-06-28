package hexmatcher.tag.domain.entity;

import hexmatcher.tag.domain.converter.FullNameConverter;
import hexmatcher.tag.domain.converter.ShortNameConverter;
import hexmatcher.tag.domain.converter.TagIdConverter;
import hexmatcher.tag.domain.valueobject.FullName;
import hexmatcher.tag.domain.valueobject.ShortName;
import hexmatcher.tag.domain.valueobject.TagId;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
public class Tag {

    @Id
    @Convert(converter = TagIdConverter.class)
    private TagId tagId;
    @Column(nullable = false)
    @Convert(converter = ShortNameConverter.class)
    private ShortName shortName;
    @Column(nullable = false, updatable = false, unique = true)
    @Convert(converter = FullNameConverter.class)
    private FullName fullName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TagType type;

    public static Tag createNew(ShortName shortName, FullName fullName, TagType type) {
        final var tag = new Tag();
        tag.tagId = new TagId(UUID.randomUUID());
        tag.shortName = shortName;
        tag.fullName = fullName;
        tag.type = type;
        return tag;
    }

}
