package hexmatcher.demand.domain.valueobject;

import java.io.Serializable;

public record DemandDescription(String value) implements ValueObject<String>, Serializable {
    private static final String NAME = "Demand description";
    public DemandDescription {
        Validation.requireNonBlank(value,NAME);
    }
}
