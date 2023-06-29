package hexmatcher.demand.domain.valueobject;

import java.io.Serializable;
import java.util.UUID;

public record CandidateId(UUID value) implements ValueObject<UUID>, Serializable {

}
