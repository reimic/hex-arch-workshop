package hexmatcher.demand.application.usecase;

import hexmatcher.demand.application.port.SaveDemandPort;
import hexmatcher.demand.domain.entity.Demand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenDemandUseCase {

    private final SaveDemandPort saveDemandPort;
    @Transactional
    public String handle(OpenDemandCommand openDemandCommand){
        log.info("Opening demand with data: {}",openDemandCommand);
        Demand demand = Demand.createNew(
                openDemandCommand.getDemandPriority(),
                openDemandCommand.getDemandType(),
                openDemandCommand.getProjectId(),
                openDemandCommand.getNeedDate(),
                openDemandCommand.getEmployeesRequired(),
                openDemandCommand.getDescription(),
                openDemandCommand.getTags()
        );
        return saveDemandPort.save(demand).toString();
    }

}
