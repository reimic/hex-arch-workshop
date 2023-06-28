package hexmatcher.employee.adapter.out.db;

import hexmatcher.employee.application.port.SaveCharacteristicPort;
import hexmatcher.employee.domain.entity.Characteristic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
class SaveCharacteristicAdapter implements SaveCharacteristicPort {
    private final CharacteristicRepository characteristicRepository;
    @Override
    public UUID save(Characteristic characteristic) {
        return characteristicRepository.save(characteristic).getCharacteristicId().value();
    }
}
