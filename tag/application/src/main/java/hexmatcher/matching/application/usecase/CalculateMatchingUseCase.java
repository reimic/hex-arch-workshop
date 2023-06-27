package hexmatcher.matching.application.usecase;

import hexmatcher.matching.application.usecase.port.GetDemandTagsPort;
import hexmatcher.matching.application.usecase.port.GetEmployeesTagsPort;
import hexmatcher.matching.domain.DemandId;
import hexmatcher.matching.domain.Matching;
import hexmatcher.matching.domain.MatchingView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalculateMatchingUseCase {

    private final GetDemandTagsPort getDemandTagsPort;

    private final GetEmployeesTagsPort getEmployeesTagsPort;

    public MatchingView apply(CalculateMatchCommand command) {
        Matching matching = Matching.createNew(command.id());

        getDemandTagsPort.findTagsByDemandId(command.id())
                         .ifPresentOrElse(matching::setDemandTags,
                                          matching::logDemandNotFound);
        if (matching.encounteredErrors()) {
            return MatchingView.from(matching);
        }
        matching.setEmployeeToTags(getEmployeesTagsPort.findEmployeesTags());
        matching.calculate();
        return MatchingView.from(matching);
    }

    public record CalculateMatchCommand(DemandId id) {

    }

}
