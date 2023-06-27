package hexmatcher.matching.domain;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
public class Matching {

    private MatchingId matchingId;
    private DemandId demandId;
    private List<TagId> demandTags;
    private Map<EmployeeId, MatchValue> employeesToMatchValues;
    private MatchingStatus matchingStatus;

    public void setDemandTags(List<TagId> demandTags) {
        this.demandTags = demandTags;
    }

    public void fail() {
        this.matchingStatus = MatchingStatus.FAILED_DEMAND_NOT_FOUND;
    }

    public void calculate(Map<EmployeeId, List<TagId>> employeesToTags){

        //employeesToTags
        /// calculations

        this.matchingStatus = MatchingStatus.CALCULATED;
    }


    public static Matching createNew(DemandId demandId) {
        var matching = new Matching();
        matching.matchingId = new MatchingId(UUID.randomUUID());
        matching.demandId = demandId;
        matching.demandTags = List.of();
        matching.employeesToMatchValues = new HashMap<>();
        matching.matchingStatus = MatchingStatus.NOT_CALCULATED;
        return matching;
    }

}
