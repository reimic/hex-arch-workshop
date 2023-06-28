package hexmatcher.tag.domain.entity;

import hexmatcher.tag.domain.valueobject.*;
import lombok.Getter;

import java.util.*;

@Getter
public class Matching {

    public static final String NO_EMPLOYEES_WITH_TAGS_PROVIDED = "No employees with tags provided.";
    public static final String DEMAND_NOT_FOUND = "Demand with id=%s not found.";
    public static final String NO_TAG_LIST_PROVIDED_OR_TAG_LIST_EMPTY = "Match for employee with id=%s set to 0. No tag list provided or tag list empty.";
    public static final String MATCH_NOT_CALCULATED = "Match not calculated. Attempted to calculate match with errors present.";
    private MatchingId matchingId;
    private DemandId demandId;
    private Set<TagId> demandTags;
    private Map<EmployeeId, Set<TagId>> employeeToTags;
    private Map<EmployeeId, MatchValue> employeeToMatchValue;
    private List<ErrorLog> errorLogs;

    public void setDemandTags(Set<TagId> demandTags) {
        this.demandTags = demandTags;
    }

    public void setEmployeeToTags(Map<EmployeeId, Set<TagId>> employeeToTags) {
        if (employeeToTags == null || employeeToTags.isEmpty()) {
            this.errorLogs.add(new ErrorLog(NO_EMPLOYEES_WITH_TAGS_PROVIDED));
        }
        this.employeeToTags = employeeToTags;
    }

    public void logDemandNotFound() {
        this.errorLogs.add(new ErrorLog(DEMAND_NOT_FOUND.formatted(demandId.value())));
    }

    public boolean encounteredErrors() {
        return !this.errorLogs.isEmpty();
    }

    public void calculate() {
        if (this.errorLogs.isEmpty()) {
            var demandTagsCount = demandTags.size();
            employeeToTags.forEach((employeeId, employeeTags) -> {
                if (employeeTags != null && !employeeTags.isEmpty()) {
                    var matchingTagsCount = employeeTags.stream()
                                                        .filter(tagId -> demandTags.contains(tagId))
                                                        .count();
                    double matchValue = (double) matchingTagsCount / demandTagsCount;
                    matchValue -= ((double) (employeeTags.size() - matchingTagsCount) / employeeTags.size()) / 10;
                    employeeToMatchValue.put(employeeId, new MatchValue(matchValue));
                } else {
                    this.errorLogs.add(new ErrorLog(
                            NO_TAG_LIST_PROVIDED_OR_TAG_LIST_EMPTY.formatted(
                                    employeeId.value())));
                    employeeToMatchValue.put(employeeId, new MatchValue());
                }
            });
        } else {
            this.errorLogs.add(new ErrorLog(MATCH_NOT_CALCULATED));
        }
    }

    public static Matching createNew(DemandId demandId) {
        var matching = new Matching();
        matching.matchingId = new MatchingId(UUID.randomUUID());
        matching.demandId = demandId;
        matching.demandTags = new HashSet<>();
        matching.employeeToTags = new HashMap<>();
        matching.employeeToMatchValue = new HashMap<>();
        matching.errorLogs = new LinkedList<>();
        return matching;
    }

}
