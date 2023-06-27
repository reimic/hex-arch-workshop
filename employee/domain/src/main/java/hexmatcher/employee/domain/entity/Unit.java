package hexmatcher.employee.domain.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static hexmatcher.employee.domain.constants.StringConstants.*;

public enum Unit {
    CCA_EM_CU_1(
            Practice.CCA,
            UNIT_NAME_CCA_EM_AGILE,
            1L),
    CCA_SE_CU_1(
            Practice.CCA,
            UNIT_NAME_CCA_SE,
            1L),
    CCA_SE_CU_2(
            Practice.CCA,
            UNIT_NAME_CCA_SE,
            2L),
    CCA_SE_CU_3(
            Practice.CCA,
            UNIT_NAME_CCA_SE,
            3L),
    CCA_SE_CU_4(
            Practice.CCA,
            UNIT_NAME_CCA_SE,
            4L),
    CCA_SE_CU_5(
            Practice.CCA,
            UNIT_NAME_CCA_SE,
            5L),
    CCA_SE_CU_6(
            Practice.CCA,
            UNIT_NAME_CCA_SE,
            6L),
    CCA_BA_CU_1(
            Practice.CCA,
            UNIT_NAME_CCA_BA_BTS,
            1L),
    CCA_HEAD(
            Practice.CCA,
            UNIT_NAME_HEAD,
            0L);
    private final Practice practice;
    private final String name;
    private final Long ordinal;

    Unit(
            Practice practice,
            String name,
            Long ordinal) {
        this.practice = practice;
        this.name = name;
        this.ordinal = ordinal;
    }
    public List<Unit> getAllByPractice(Practice practice) {
        return Arrays
                .stream(Unit.values())
                .filter(u -> Objects.equals(
                        u.practice,
                        practice))
                .toList();
    }
    public List<Unit> getAllByName(String name) {
        return Arrays
                .stream(Unit.values())
                .filter(u -> Objects.equals(
                        u.name,
                        name))
                .toList();
    }
    public Practice getPractice() {
        return practice;
    }
    public String getName() {
        return name;
    }
    public Long getOrdinal() {
        return ordinal;
    }

}
