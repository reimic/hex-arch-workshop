package hexmatcher.tag.application.usecase;

import hexmatcher.tag.application.usecase.port.GetDemandTagsPort;
import hexmatcher.tag.application.usecase.port.GetEmployeesTagsPort;
import hexmatcher.tag.domain.valueobject.ErrorLog;
import hexmatcher.tag.domain.valueobject.MatchValue;
import hexmatcher.tag.domain.entity.Matching;
import hexmatcher.tag.domain.valueobject.DemandId;
import hexmatcher.tag.domain.valueobject.EmployeeId;
import hexmatcher.tag.domain.valueobject.MatchingId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CalculateMatchingUseCase {

    private final GetDemandTagsPort getDemandTagsPort;

    private final GetEmployeesTagsPort getEmployeesTagsPort;

    public MatchingView apply(CalculateMatchCommand command) {
        Matching matching = Matching.createNew(command.demandId());
        getDemandTagsPort.findTagsByDemandId(command.demandId())
                         .ifPresentOrElse(matching::setDemandTags,
                                          matching::logDemandNotFound);
        if (matching.encounteredErrors()) {
            return MatchingView.from(matching);
        }
        matching.setEmployeeToTags(getEmployeesTagsPort.findEmployeesTags());
        matching.calculate();
        return MatchingView.from(matching);
    }

    public record CalculateMatchCommand(DemandId demandId) {

    }

    public record MatchingView(MatchingId matchingId,
                               DemandId demandId,
                               Map<EmployeeId, MatchValue> employeeToMatchValue,
                               List<ErrorLog> errorLogs) {

        public static MatchingView from(Matching matching) {
            return new MatchingView(matching.getMatchingId(),
                                    matching.getDemandId(),
                                    matching.getEmployeeToMatchValue(),
                                    matching.getErrorLogs());
        }

    }

}
