package hexmatcher.demand.domain.valueobject;

import java.io.Serializable;
import java.time.LocalDate;

public record NeedDate(LocalDate value) implements ValueObject<LocalDate>, Serializable {

}
