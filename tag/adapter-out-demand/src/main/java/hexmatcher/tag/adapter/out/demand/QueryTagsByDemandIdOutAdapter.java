package hexmatcher.tag.adapter.out.demand;

import hexmatcher.demand.adapter.in.tag.QueryTagsByDemandIdInAdapter;
import hexmatcher.tag.application.port.GetDemandTagsPort;
import hexmatcher.tag.domain.valueobject.DemandId;
import hexmatcher.tag.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QueryTagsByDemandIdOutAdapter implements GetDemandTagsPort {
    private final QueryTagsByDemandIdInAdapter queryTagsByDemandIdInAdapterPort;

    @Override
    public Optional<Set<TagId>> findTagsByDemandId(DemandId demandId) {
        hexmatcher.demand.domain.valueobject.DemandId mappedDemandId = new hexmatcher.demand.domain.valueobject.DemandId(demandId.value());
        Set<hexmatcher.demand.domain.valueobject.TagId> tagIds = queryTagsByDemandIdInAdapterPort.findTagsByDemandId(mappedDemandId)
                .orElse(Collections.emptySet());
        return Optional.of(tagIds.stream().map(tagId -> new TagId(tagId.value())).collect(Collectors.toSet()));
    }
}
