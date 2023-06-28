package hexmatcher.employee.application.port;

import hexmatcher.employee.domain.entity.Characteristic;

import java.util.UUID;

@FunctionalInterface
public interface SaveCharacteristicPort {
    UUID save(Characteristic characteristic);
}
