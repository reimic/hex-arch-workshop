package hexmatcher.matching.domain;

import java.util.List;
import java.util.Map;

public record MatchingView(MatchingId matchingId,
                           DemandId demandId,
                           Map<EmployeeId,MatchValue> employeeToMatchValue,
                           List<ErrorLog> errorLogs) {

    public static MatchingView from(Matching matching) {
        return new MatchingView(matching.getMatchingId(),
                                matching.getDemandId(),
                                matching.getEmployeeToMatchValue(),
                                matching.getErrorLogs());
    }

}
