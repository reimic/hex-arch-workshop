package hexmatcher.tag.application.usecase.port;

import hexmatcher.tag.domain.valueobject.EmployeeId;
import hexmatcher.tag.domain.valueobject.TagId;

import java.util.Map;
import java.util.Set;

public interface GetEmployeesTagsPort {

    Map<EmployeeId, Set<TagId>> findEmployeesTags();

}
