package hexmatcher.demand.application.usecase;

import hexmatcher.demand.application.port.SaveDemandPort;
import hexmatcher.demand.domain.entity.Demand;
import hexmatcher.demand.domain.entity.DemandPriority;
import hexmatcher.demand.domain.entity.DemandType;
import hexmatcher.demand.domain.valueobject.ProjectId;
import hexmatcher.demand.domain.valueobject.TagId;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
@Validated
public class OpenDemandUseCase {

    private final SaveDemandPort saveDemandPort;
    @Transactional
    public String handle(@Valid OpenDemandCommand openDemandCommand){
        log.info("Opening demand with data: {}",openDemandCommand);
        Demand demand = Demand.createNew(
                openDemandCommand.demandPriority(),
                openDemandCommand.demandType(),
                openDemandCommand.projectId(),
                openDemandCommand.needDate(),
                openDemandCommand.employeesRequired(),
                openDemandCommand.description(),
                openDemandCommand.tags()
        );
        return saveDemandPort.save(demand).toString();
    }

    public record OpenDemandCommand(
            @NotNull DemandPriority demandPriority,
            @NotNull DemandType demandType,
            @NotNull ProjectId projectId,
            @NotNull LocalDate needDate,
            Long employeesRequired,
            String description,
            Set<TagId> tags)
    {
    }
}
