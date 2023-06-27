package hexmatcher.matching.domain;

public record MatchValue(double matchValue) {
    public MatchValue{
        if(matchValue < 0 || matchValue > 1){
            throw new ValidationException("Match value not in range 0 to 1.");
        }
    }
}
