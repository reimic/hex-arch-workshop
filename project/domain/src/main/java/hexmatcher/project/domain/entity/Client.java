package hexmatcher.project.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
public class Client {

    @Id
//    @Convert(converter = ClientIdConverter.class)
    private UUID clientId;
    @Column(nullable = false, unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MarketUnit marketUnit;
    @OneToMany(mappedBy = "client")
    @EqualsAndHashCode.Exclude
    private Set<Project> projects = new HashSet<>();

    public static Client createNew(String name,MarketUnit marketUnit){
        final var client = new Client();
//        client.clientId = new ClientId(UUID.randomUUID());
        client.clientId = UUID.randomUUID();
        client.name=name;
        client.marketUnit=marketUnit;
        return client;
    }

}
