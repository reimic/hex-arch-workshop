package hexmatcher.demand.domain.converter;

import hexmatcher.demand.domain.valueobject.NeedDate;
import jakarta.persistence.AttributeConverter;

import java.time.LocalDate;

public class NeedDateConverter implements AttributeConverter<NeedDate, LocalDate> {
    @Override
    public LocalDate convertToDatabaseColumn(NeedDate attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.value();
    }

    @Override
    public NeedDate convertToEntityAttribute(LocalDate dbData) {
        return new NeedDate(dbData);
    }
}
