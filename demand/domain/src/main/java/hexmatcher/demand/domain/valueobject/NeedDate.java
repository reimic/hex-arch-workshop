package hexmatcher.demand.domain.valueobject;

import java.io.Serializable;
import java.time.LocalDate;


public record NeedDate(LocalDate value) implements ValueObject<LocalDate>, Serializable {

    private static final String NAME = "Need Date";

    public NeedDate {
        Validation.requireLocalDateToBeAfterToday(value, NAME);
    }
}
