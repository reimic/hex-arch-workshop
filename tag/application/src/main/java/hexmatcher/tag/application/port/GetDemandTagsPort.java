package hexmatcher.tag.application.port;

import hexmatcher.tag.domain.valueobject.DemandId;
import hexmatcher.tag.domain.valueobject.TagId;

import java.util.Optional;
import java.util.Set;

public interface GetDemandTagsPort {

    Optional<Set<TagId>> findTagsByDemandId(DemandId demandId);

}
