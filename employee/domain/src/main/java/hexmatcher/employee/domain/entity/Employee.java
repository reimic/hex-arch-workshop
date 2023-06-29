package hexmatcher.employee.domain.entity;

import hexmatcher.employee.domain.converter.EmployeeIdConverter;
import hexmatcher.employee.domain.converter.ProjectIdConverter;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.ProjectId;
import hexmatcher.employee.domain.valueobject.TagId;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@EqualsAndHashCode
public class Employee {
    @Id
    @Convert(converter = EmployeeIdConverter.class)
    private EmployeeId employeeId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    @Convert(converter = ProjectIdConverter.class)
    private ProjectId projectId;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Characteristic> characteristics = new HashSet<>();

    public static Employee createNew(
        String firstName,
        String lastName,
        ProjectId projectId,
        Set<TagId> tags
    ){
        final var employee = new Employee();
        employee.employeeId = new EmployeeId(UUID.randomUUID());
        employee.firstName = firstName;
        employee.lastName = lastName;
        employee.projectId = projectId;
        employee.characteristics = (tags == null || tags.isEmpty()) ? null : tags.stream()
                .map(tagId -> Characteristic.createNew(employee, tagId)).collect(Collectors.toSet());
        return employee;
    }

    public void acceptProject(ProjectId projectId){
        this.projectId = projectId;
    }
}
