package hexmatcher.demand.domain.valueobject;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ValidationTest {

    @Test
    void shouldThrowException_whenCreatingNeedDate_andNeedDateIsEqualToday(){
        //given
        //when
        //then
        assertThatThrownBy(()->new NeedDate(LocalDate.now()))
                .isInstanceOf(ValidationException.class);
    }
    @Test
    void shouldThrowException_whenCreatingNeedDate_andNeedDateIsBeforeToday(){
        //given
        //when
        //then
        assertThatThrownBy(()->new NeedDate(LocalDate.now().minusDays(1L)))
                .isInstanceOf(ValidationException.class);
    }
    @Test
    void shouldCreateNeedDate_whenNeedDayIsOneDayAfterToday(){
        //given
        NeedDate needDate = new NeedDate(LocalDate.now().plusDays(1L));
        //when
        //then
        assertThat(needDate).isNotNull();
    }
    @Test
    void shouldThrowException_whenCreatingDemandDescription_andDemandDescriptionIsNull(){
        //given
        //when
        //then
        assertThatThrownBy(()->new DemandDescription(null))
                .isInstanceOf(ValidationException.class);
    }

    @Test
    void shouldThrowException_whenCreatingDemandDescription_andDemandDescriptionIsBlank(){
        //given
        //when
        //then
        assertThatThrownBy(()->new DemandDescription(" "))
                .isInstanceOf(ValidationException.class);
    }

    @Test
    void shouldCreateDemandDescription_whenCreatingDemandDescription(){
        //given
        DemandDescription demandDescription = new DemandDescription("Demand desc...");
        //when
        //then
        assertThat(demandDescription).isNotNull();
    }

}
