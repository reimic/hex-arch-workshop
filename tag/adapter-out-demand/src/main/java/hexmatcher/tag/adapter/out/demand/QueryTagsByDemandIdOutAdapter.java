package hexmatcher.tag.adapter.out.demand;

import hexmatcher.tag.application.port.GetDemandTagsPort;
import hexmatcher.tag.domain.valueobject.DemandId;
import hexmatcher.tag.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
class QueryTagsByDemandIdOutAdapter implements GetDemandTagsPort {
    @Override
    public Optional<Set<TagId>> findTagsByDemandId(DemandId demandId) {
        return Optional.empty();
    }
}
