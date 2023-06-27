package hexmatcher.matching.domain;

import java.util.Map;

public record MatchingView(MatchingId matchingId,
                           DemandId demandId,
                           Map<EmployeeId,MatchValue> employeeToMatchValue,
                           MatchingStatus matchingStatus) {

    public static MatchingView from(Matching matching) {
        return new MatchingView(matching.getMatchingId(),
                                matching.getDemandId(),
                                matching.getEmployeesToMatchValues(),
                                matching.getMatchingStatus());
    }

}
