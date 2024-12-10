package pairmatching.domain;

public enum Function {
    PAIR_MATCHING("페어 매칭", "1"),
    PAIR_CHECK("페어 조회", "2"),
    PAIR_RESET("페어 초기화", "3"),
    QUIT("종료", "Q");

    private final String optionName;
    private final String selectName;

    Function(String optionName, String selectName) {
        this.optionName = optionName;
        this.selectName = selectName;
    }

    public String getOptionName() {
        return optionName;
    }

    public String getSelectName() {
        return selectName;
    }
}
