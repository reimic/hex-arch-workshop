package hexmatcher.demand.application.usecase;

import hexmatcher.demand.application.port.QueryTagsByDemandIdPort;
import hexmatcher.demand.domain.valueobject.DemandId;
import hexmatcher.demand.domain.valueobject.TagId;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
@Validated
public class QueryTagsByDemandIdUseCase {
    private final QueryTagsByDemandIdPort queryTagsByDemandIdPort;

    @Transactional
    public Optional<Set<TagId>> handle(@NotNull DemandId demandId){
        log.info("Searching for tags with demand id=: {}",demandId.value());
        return queryTagsByDemandIdPort.findTagsByDemandId(demandId);
    }
}
