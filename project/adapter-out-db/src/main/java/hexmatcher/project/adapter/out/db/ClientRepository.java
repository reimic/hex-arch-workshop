package hexmatcher.project.adapter.out.db;

import hexmatcher.project.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface ClientRepository extends JpaRepository<Client, UUID> {
}
