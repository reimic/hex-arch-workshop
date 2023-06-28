package hexmatcher.project.domain.valueobject;

import java.io.Serializable;
import java.util.UUID;


public record ClientId(UUID value) implements ValueObject<UUID>, Serializable {
}
