package hexmatcher.project.domain.converter;

import hexmatcher.project.domain.valueobject.ClientId;

import java.util.UUID;

public class ClientIdConverter extends UuidValueObjectConverter<ClientId> {
    @Override
    public ClientId convertToEntityAttribute(UUID dbData) {
        return new ClientId(dbData);
    }
}
