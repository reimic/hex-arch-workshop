package hexmatcher.tag.domain.entity;

public enum TagType {
    POSITION("position"),
    PROFESSIONAL_COMPETENCY("professional competency"),
    TECHNICAL_SKILL("technical skill"),
    LOCATION("location"),
    LANGUAGE("language"),
    GRADE("grade");
    private final String dbValue;
    TagType(String dbValue){
        this.dbValue = dbValue;
    }

    public String getDbValue(){
        return dbValue;
    }

    public static TagType fromDb(String dbValue) {
        return switch (dbValue) {
            case "position" -> POSITION;
            case "professional competency" -> PROFESSIONAL_COMPETENCY;
            case "technical skill" -> TECHNICAL_SKILL;
            case "location" -> LOCATION;
            case "language" -> LANGUAGE;
            case "grade" -> GRADE;
            default -> throw new RuntimeException();
        };
    }

}
