package hexmatcher.employee.adapter.out.db;

import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.TagId;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository {
    private final EntityManager entityManager;

    @Override
    public Map<EmployeeId, Set<TagId>> getAllEmployeesWithTags() {
        List<Object[]> resultList = entityManager.createQuery("""
                    select
                        e.employeeId,
                        c.tagId
                    from Characteristic c
                    join c.employee e
                    where e.projectId IS NULL
                """).getResultList();

       return resultList.stream().collect(Collectors.groupingBy(
                o -> (EmployeeId) o[0],
                Collectors.mapping(o -> (TagId) o[1], Collectors.toSet())
        ));
    }
}
