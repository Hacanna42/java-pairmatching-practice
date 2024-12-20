package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public enum Mission {
    CAR_RACING("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL("숫자야구게임", Level.LEVEL1),

    SHOPPING_CART("장바구니", Level.LEVEL2),
    PURCHASE("결제", Level.LEVEL2),
    SUBWAY_MAP("지하노선도", Level.LEVEL2),

    PERFORMANCE_IMPROVE("성능개선", Level.LEVEL4),
    RELEASE("배포", Level.LEVEL4);

    private final String name;
    private final Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public static List<String> getNamesFrom(Level level) {
        List<String> foundNames = new ArrayList<>();
        for (Mission mission : Mission.values()) {
            if (mission.level == level) {
                foundNames.add(mission.name);
            }
        }

        return foundNames;
    }

    public static Mission fromName(String name) {
        for (Mission mission : Mission.values()) {
            if (mission.name.equals(name)) {
                return mission;
            }
        }
        throw new IllegalArgumentException("올바르지 않은 미션입니다.");
    }

    public boolean isSameLevel(Level level) {
        return this.level == level;
    }

    public boolean isSameLevel(Mission mission) {
        return this.level == mission.level;
    }
}
