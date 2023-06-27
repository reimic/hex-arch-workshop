package hexmatcher.matching.application.usecase.port;

import hexmatcher.matching.domain.EmployeeId;
import hexmatcher.matching.domain.TagId;

import java.util.List;
import java.util.Map;

public interface GetEmployeesTagsPort {

    Map<EmployeeId, List<TagId>> findEmployeesTags();

}
