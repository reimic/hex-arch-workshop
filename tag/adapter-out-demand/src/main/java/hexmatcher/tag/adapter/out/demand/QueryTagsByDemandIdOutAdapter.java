package hexmatcher.tag.adapter.out.demand;

import hexmatcher.demand.adapter.in.tag.QueryTagsByDemandIdInAdapter;
import hexmatcher.tag.application.port.GetDemandTagsPort;
import hexmatcher.tag.domain.valueobject.DemandId;
import hexmatcher.tag.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QueryTagsByDemandIdOutAdapter implements GetDemandTagsPort {
    private final QueryTagsByDemandIdInAdapter queryTagsByDemandIdInAdapterPort;

    @Override
    public Optional<Set<TagId>> findTagsByDemandId(DemandId demandId) {
        Optional<Set<hexmatcher.demand.domain.valueobject.TagId>> tagsByDemandId =
                queryTagsByDemandIdInAdapterPort.findTagsByDemandId(new hexmatcher.demand.domain.valueobject.DemandId(demandId.value()));
        Set<TagId> collect = tagsByDemandId.get().stream().map(t -> new TagId(t.value())).collect(Collectors.toSet());
        return Optional.of(collect);
    }
}
