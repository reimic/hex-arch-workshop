package hexmatcher.project.domain.entity;

import hexmatcher.project.domain.converter.ProjectIdConverter;
import hexmatcher.project.domain.valueobject.ProjectId;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
public class Project {

    @Id
    @Convert(converter = ProjectIdConverter.class)
    private ProjectId projectId;
    private Double businessPriorityIndex;
    @Column(nullable = false, unique = true)
    private String name;
    private String engagementManagerEmail;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private Client client;

    public static Project createNew(
            Double businessPriorityIndex,
            String name,
            String engagementManagerEmail,
            String description,
            Client client)
    {
        final var project = new Project();
        project.projectId=new ProjectId(UUID.randomUUID());
        project.businessPriorityIndex=businessPriorityIndex;
        project.name=name;
        project.engagementManagerEmail=engagementManagerEmail;
        project.description=description;
        project.client=client;
        return project;
    }

}
