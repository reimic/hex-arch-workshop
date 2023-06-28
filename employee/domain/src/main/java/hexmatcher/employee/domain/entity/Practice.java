package hexmatcher.employee.domain.entity;

public enum Practice {
    CCA("C&CA"),
    DCX("DCX"),
    NTC("NTC"),
    ADM("ADM"),
    SAP("SAP"),
    INSIGHT("INSIGHT & DATA");
    private final String name;
    Practice(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
