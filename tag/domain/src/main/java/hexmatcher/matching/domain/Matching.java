package hexmatcher.matching.domain;

import lombok.Getter;

import java.util.*;

@Getter
public class Matching {

    private MatchingId matchingId;
    private DemandId demandId;
    private List<TagId> demandTags;
    private Map<EmployeeId, List<TagId>> employeeToTags;
    private Map<EmployeeId, MatchValue> employeeToMatchValue;
    private List<ErrorLog> errorLogs;

    public void setDemandTags(List<TagId> demandTags) {
        this.demandTags = demandTags;
    }

    public void setEmployeeToTags(Map<EmployeeId, List<TagId>> employeeToTags) {
        if (employeeToTags == null || employeeToTags.isEmpty()) {
            this.errorLogs.add(new ErrorLog("No employees with tags provided."));
        }
        this.employeeToTags = employeeToTags;
    }

    public void logDemandNotFound() {
        this.errorLogs.add(new ErrorLog("Demand with id=%s not provided.".formatted(demandId.id())));
    }

    public boolean encounteredErrors() {
        return !this.errorLogs.isEmpty();
    }

    public void calculate() {
        if (this.errorLogs.isEmpty()) {
            var demandTagsCount = demandTags.size();

            employeeToTags.forEach((employeeId, employeeTags) -> {
                if (employeeTags == null || employeeTags.isEmpty()) {
                    employeeToMatchValue.put(employeeId, new MatchValue(0));
                } else {
                    var matchingTagsCount = employeeTags.stream()
                                                        .distinct()
                                                        .filter(tagId -> demandTags.contains(tagId))
                                                        .count();
                    double matchValue = (double) matchingTagsCount / demandTagsCount;
                    matchValue -= ((double) (employeeTags.size() - matchingTagsCount) / employeeTags.size()) / 10;
                    if (matchValue < 0) {
                        matchValue = 0;
                    }
                    employeeToMatchValue.put(employeeId, new MatchValue(matchValue));
                }

            });

        } else {
            this.errorLogs.add(new ErrorLog("Match not calculated. Attempted to calculate match with errors present."));
        }

    }

    public static Matching createNew(DemandId demandId) {
        var matching = new Matching();
        matching.matchingId = new MatchingId(UUID.randomUUID());
        matching.demandId = demandId;
        matching.demandTags = new LinkedList<>();
        matching.employeeToTags = new HashMap<>();
        matching.employeeToMatchValue = new HashMap<>();
        matching.errorLogs = new LinkedList<>();
        return matching;
    }

}
