package pairmatching.view;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class OutputView {
    public static void printOverallStatus() {
        System.out.println("#############################################");
        printCourses();
        printMissions();
        System.out.println("############################################");
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
