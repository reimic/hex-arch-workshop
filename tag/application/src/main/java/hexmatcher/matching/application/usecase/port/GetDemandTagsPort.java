package hexmatcher.matching.application.usecase.port;

import hexmatcher.matching.domain.DemandId;
import hexmatcher.matching.domain.TagId;

import java.util.List;
import java.util.Optional;

public interface GetDemandTagsPort {

    Optional<List<TagId>> findTagsByDemandId(DemandId demandId);

}
