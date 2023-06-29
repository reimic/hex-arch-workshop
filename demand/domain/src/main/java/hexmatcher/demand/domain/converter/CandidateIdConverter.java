package hexmatcher.demand.domain.converter;

import hexmatcher.demand.domain.valueobject.CandidateId;

import java.util.UUID;

public class CandidateIdConverter extends UuidValueObjectConverter<CandidateId> {
    @Override
    public CandidateId convertToEntityAttribute(UUID dbData) {
        return new CandidateId(dbData);
    }
}
