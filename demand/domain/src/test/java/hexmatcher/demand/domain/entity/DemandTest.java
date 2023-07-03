package hexmatcher.demand.domain.entity;

import hexmatcher.demand.domain.valueobject.CandidateId;
import hexmatcher.demand.domain.valueobject.EmployeeId;
import hexmatcher.demand.domain.valueobject.ProjectId;
import hexmatcher.demand.domain.valueobject.TagId;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import static hexmatcher.demand.domain.entity.Candidate.CAN_NOT_ACCEPT_CANDIDATE_WHEN_CURRENT_CANDIDATE_STATUS_DIFFER_FROM_PROPOSED;
import static hexmatcher.demand.domain.entity.Candidate.CAN_NOT_REJECT_CANDIDATE_WHEN_CURRENT_CANDIDATE_STATUS_DIFFER_FROM_PROPOSED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class DemandTest {

    @Test
    void shouldCreateDemand() {
        //given
        //when
        Demand demand = Demand.createNew(
                DemandPriority.ONE,
                DemandType.REAL,
                new ProjectId(UUID.randomUUID()),
                LocalDate.now(),
                2L,
                "Demand description",
                Set.of(new TagId(UUID.randomUUID()), new TagId(UUID.randomUUID()))
        );
        //then
        assertAll(
                () -> assertThat(demand.getDemandId()).isNotNull(),
                () -> assertThat(demand.getCandidates()).isEmpty(),
                () -> assertThat(demand.getSpecifications()).hasSize(2)
        );
    }

    @Test
    void shouldProposeCandidate() {
        //given
        Demand demand = Demand.createNew(
                DemandPriority.ONE,
                DemandType.REAL,
                new ProjectId(UUID.randomUUID()),
                LocalDate.now(),
                2L,
                "Demand description",
                Set.of(new TagId(UUID.randomUUID()), new TagId(UUID.randomUUID()))
        );
        EmployeeId employeeId = new EmployeeId(UUID.randomUUID());
        //when
        demand.proposeCandidate(employeeId);
        //then
        assertAll(
                () -> assertThat(demand.getCandidates()).hasSize(1),
                () -> assertThat(demand.getCandidates().stream().findFirst().get().getCandidateId()).isNotNull(),
                () -> assertThat(demand.getCandidates().stream().findFirst().get().getCandidateStatus()).isEqualTo(CandidateStatus.PROPOSED)
        );
    }

    @Test
    void shouldAcceptCandidate() {
        //given
        Demand demand = Demand.createNew(
                DemandPriority.ONE,
                DemandType.REAL,
                new ProjectId(UUID.randomUUID()),
                LocalDate.now(),
                2L,
                "Demand description",
                Set.of(new TagId(UUID.randomUUID()), new TagId(UUID.randomUUID()))
        );
        EmployeeId employeeId = new EmployeeId(UUID.randomUUID());
        CandidateId candidateId = demand.proposeCandidate(employeeId);
        //when
        demand.acceptCandidate(candidateId);
        //then
        assertThat(demand.getCandidates().stream().findFirst().get().getCandidateStatus()).isEqualTo(CandidateStatus.ACCEPTED);
    }

    @Test
    void shouldThrowException_whenAcceptingCandidate_andThereIsNoCandidateAssignedToDemand() {
        //given
        Demand demand = Demand.createNew(
                DemandPriority.ONE,
                DemandType.REAL,
                new ProjectId(UUID.randomUUID()),
                LocalDate.now(),
                2L,
                "Demand description",
                Set.of(new TagId(UUID.randomUUID()), new TagId(UUID.randomUUID()))
        );
        CandidateId candidateId = new CandidateId(UUID.randomUUID());
        //when
        //then
        assertThatThrownBy(() -> {
            demand.acceptCandidate(candidateId);
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(Demand.THERE_IS_NO_CANDIDATE_WITH_ID.formatted(candidateId.value()));
    }

    @Test
    void shouldThrowException_whenAcceptingCandidate_andCandidateStatusIsAlreadySetToAccepted() {
        //given
        Demand demand = Demand.createNew(
                DemandPriority.ONE,
                DemandType.REAL,
                new ProjectId(UUID.randomUUID()),
                LocalDate.now(),
                2L,
                "Demand description",
                Set.of(new TagId(UUID.randomUUID()), new TagId(UUID.randomUUID()))
        );
        EmployeeId employeeId = new EmployeeId(UUID.randomUUID());
        CandidateId candidateId = demand.proposeCandidate(employeeId);
        demand.acceptCandidate(candidateId);
        //when
        //then
        assertThatThrownBy(() -> {
            demand.acceptCandidate(candidateId);
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(CAN_NOT_ACCEPT_CANDIDATE_WHEN_CURRENT_CANDIDATE_STATUS_DIFFER_FROM_PROPOSED);
    }

    @Test
    void shouldRejectCandidate() {
        //given
        Demand demand = Demand.createNew(
                DemandPriority.ONE,
                DemandType.REAL,
                new ProjectId(UUID.randomUUID()),
                LocalDate.now(),
                2L,
                "Demand description",
                Set.of(new TagId(UUID.randomUUID()), new TagId(UUID.randomUUID()))
        );
        EmployeeId employeeId = new EmployeeId(UUID.randomUUID());
        CandidateId candidateId = demand.proposeCandidate(employeeId);
        //when
        demand.rejectCandidate(candidateId);
        //then
        assertThat(demand.getCandidates().stream().findFirst().get().getCandidateStatus()).isEqualTo(CandidateStatus.REJECTED);
    }

    @Test
    void shouldThrowException_whenRejectingCandidate_andThereIsNoCandidateAssignedToDemand() {
        //given
        Demand demand = Demand.createNew(
                DemandPriority.ONE,
                DemandType.REAL,
                new ProjectId(UUID.randomUUID()),
                LocalDate.now(),
                2L,
                "Demand description",
                Set.of(new TagId(UUID.randomUUID()), new TagId(UUID.randomUUID()))
        );
        CandidateId candidateId = new CandidateId(UUID.randomUUID());
        //when
        //then
        assertThatThrownBy(() -> {
            demand.rejectCandidate(candidateId);
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(Demand.THERE_IS_NO_CANDIDATE_WITH_ID.formatted(candidateId.value()));
    }

    @Test
    void shouldThrowException_whenRejectingCandidate_andCandidateStatusIsAlreadySetToRejected() {
        //given
        Demand demand = Demand.createNew(
                DemandPriority.ONE,
                DemandType.REAL,
                new ProjectId(UUID.randomUUID()),
                LocalDate.now(),
                2L,
                "Demand description",
                Set.of(new TagId(UUID.randomUUID()), new TagId(UUID.randomUUID()))
        );
        EmployeeId employeeId = new EmployeeId(UUID.randomUUID());
        CandidateId candidateId = demand.proposeCandidate(employeeId);
        demand.rejectCandidate(candidateId);
        //when
        //then
        assertThatThrownBy(() -> {
            demand.rejectCandidate(candidateId);
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(CAN_NOT_REJECT_CANDIDATE_WHEN_CURRENT_CANDIDATE_STATUS_DIFFER_FROM_PROPOSED);
    }

}
