package hexmatcher.tag.adapter.in.web;


import hexmatcher.tag.application.usecase.CalculateMatchingUseCase;
import hexmatcher.tag.application.usecase.CalculateMatchingUseCase.CalculateMatchCommand;
import hexmatcher.tag.application.usecase.CalculateMatchingUseCase.MatchingView;
import hexmatcher.tag.domain.valueobject.DemandId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class CalculateMatchingRestAdapter {
    private final CalculateMatchingUseCase calculateMatchingUseCase;

    @GetMapping("tags/{demandId}")
    MatchingView getMatchValues(@PathVariable String demandId){
        return calculateMatchingUseCase.apply(new CalculateMatchCommand(new DemandId(UUID.fromString(demandId))));
    }
}
