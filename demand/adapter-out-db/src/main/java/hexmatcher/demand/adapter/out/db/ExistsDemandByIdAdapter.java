package hexmatcher.demand.adapter.out.db;


import hexmatcher.demand.application.port.ExistsDemandByIdPort;
import hexmatcher.demand.domain.valueobject.DemandId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class ExistsDemandByIdAdapter implements ExistsDemandByIdPort {

    private final DemandRepository demandRepository;
    @Override
    public boolean existsById(DemandId demandId) {
        return demandRepository.existsById(demandId);
    }
}
