package hexmatcher.project.adapter.out.db;

import hexmatcher.project.domain.entity.Client;
import hexmatcher.project.domain.valueobject.ClientId;
import org.springframework.data.jpa.repository.JpaRepository;

interface ClientRepository extends JpaRepository<Client, ClientId> {
}
