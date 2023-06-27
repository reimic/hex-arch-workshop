package hexmatcher.project.adapter.in.web;

import hexmatcher.project.application.port.in.ProjectsByClientIdView;
import hexmatcher.project.application.port.in.QueryProjectsByClientIdUseCase;
import hexmatcher.project.domain.valueobject.ClientId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
class QueryProjectsByClientIdRestAdapter {


    private final QueryProjectsByClientIdUseCase queryProjectsByClientIdUseCase;

    @GetMapping("projects/client/{clientId}")
    List<ProjectsByClientIdView> getProjectsByClientId(@PathVariable String clientId){
        return queryProjectsByClientIdUseCase.queryBy(new ClientId(UUID.fromString(clientId)));
    }
}
