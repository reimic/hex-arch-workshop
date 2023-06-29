package hexmatcher.employee.adapter.out.db;

import hexmatcher.employee.application.usecase.QueryCharacteristicByEmployeeIdUseCase.CharacteristicsByEmployeeIdView;
import hexmatcher.employee.domain.entity.Characteristic;
import hexmatcher.employee.domain.valueobject.CharacteristicId;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface CharacteristicRepository extends JpaRepository<Characteristic, CharacteristicId> {
    @Query("""
        select
            c.tagId as tagId
        from Characteristic  c
        join c.employee e
        where e.employeeId = :employeeId
    """)
    List<CharacteristicsByEmployeeIdView> queryBy(@Param("employeeId")EmployeeId employeeId);
}
