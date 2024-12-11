package pairmatching.view;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;

public class OutputView {
    public static void printOverallStatus() {
        System.out.println();
        System.out.println("#############################################");
        printCourses();
        printMissions();
        System.out.println("############################################");
    }

    public static void printMatchingResult(List<Pair> matchedPairs) {
        System.out.println();
        System.out.println("페어 매칭 결과입니다.");
        for (Pair pair : matchedPairs) {
            System.out.println(pair.toString());
        }
        System.out.println();
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static void printClearPairMessage() {
        System.out.println("초기화 되었습니다.");
    }

    private static void printCourses() {
        System.out.println("과정: " + String.join(" | ", Course.getStringValues()));
    }

    private static void printMissions() {
        System.out.println("미션:");
        for (Level level : Level.values()) {
            System.out.printf("- %s: ", level.getName());
            List<String> missionNamesOfLevel = Mission.getNamesFrom(level);
            System.out.println(String.join(" | ", missionNamesOfLevel));
        }
    }
}
