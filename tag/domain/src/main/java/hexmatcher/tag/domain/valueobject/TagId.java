package hexmatcher.tag.domain.valueobject;

import java.io.Serializable;
import java.util.UUID;

public record TagId(UUID value) implements ValueObject<UUID>, Serializable {

}
