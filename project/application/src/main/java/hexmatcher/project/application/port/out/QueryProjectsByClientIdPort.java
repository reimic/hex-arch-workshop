package hexmatcher.project.application.port.out;

import hexmatcher.project.application.port.in.ProjectsByClientIdView;
import hexmatcher.project.domain.valueobject.ClientId;

import java.util.List;

@FunctionalInterface
public interface QueryProjectsByClientIdPort {
    List<ProjectsByClientIdView> queryBy(ClientId clientId);
}
