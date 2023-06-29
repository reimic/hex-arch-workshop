package hexmatcher.employee.adapter.in.web;

import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.TagId;

record CharacteristicCreationRequest(
    EmployeeId employeeId,
    TagId tagId
) {
}
