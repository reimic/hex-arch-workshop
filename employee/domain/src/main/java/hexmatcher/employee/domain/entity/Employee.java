package hexmatcher.employee.domain.entity;

import hexmatcher.employee.domain.converter.EmployeeIdConverter;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.UUID;

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

    @OneToMany(mappedBy = "employee")
    private Collection<Characteristic> characteristics;

    public static Employee createNew(
        String firstName,
        String lastName,
        Collection<Characteristic> characteristics
    ){
        final var employee = new Employee();
        employee.employeeId = new EmployeeId(UUID.randomUUID());
        employee.firstName = firstName;
        employee.lastName = lastName;
        employee.characteristics = characteristics;
        return employee;
    }
}
