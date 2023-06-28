package hexmatcher.tag.domain.valueobject;

import java.io.Serializable;
import java.util.UUID;

public record MatchingId(UUID value) implements ValueObject<UUID>, Serializable {

}
