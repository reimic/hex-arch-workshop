package hexmatcher.tag.domain.valueobject;

import java.io.Serializable;

public record MatchValue(Double value) implements ValueObject<Double>, Serializable {

    public MatchValue() {
        this((double) 0);
    }

    public MatchValue {
        if (value < 0) {
            value = (double) 0;
        }
        if (value > 1) {
            value = (double) 1;
        }
    }

}

