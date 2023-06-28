package hexmatcher.demand.application.usecase;

import hexmatcher.demand.domain.valueobject.NeedDate;
import hexmatcher.demand.domain.valueobject.OpenPositions;
import hexmatcher.demand.domain.valueobject.ProjectId;
import hexmatcher.demand.domain.valueobject.TagId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OpenDemandUseCase {

    public DemandView apply(OpenDemandCommand command) {


        return new DemandView();
    }

    public record OpenDemandCommand(ProjectId projectId,
                                    NeedDate needDate,
                                    OpenPositions openPositions,
                                    List<TagId> tags) {

    }

    public record DemandView() {

    }

}
