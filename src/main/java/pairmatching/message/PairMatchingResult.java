package pairmatching.message;

public enum PairMatchingResult {
    SUCCESS(""),
    IS_ALREADY_MATCHED("매칭 정보가 있습니다. 다시 매칭하시겠습니까?"),
    FAILED_MATCHING("3회 연속으로 같은 페어가 매칭되어서 매칭에 실패하였습니다."),

    NO_MATCHING_LOG("매칭 이력이 없습니다.");

    private final String message;

    PairMatchingResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
