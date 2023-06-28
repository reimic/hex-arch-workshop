package hexmatcher.project.domain.valueobject;

import java.io.Serializable;
import java.util.UUID;

public record ProjectId(UUID value) implements ValueObject<UUID>, Serializable {
}
