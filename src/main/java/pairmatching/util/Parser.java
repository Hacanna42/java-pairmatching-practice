package pairmatching.util;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.dto.SelectedTargetDto;

public class Parser {
    public static SelectedTargetDto makeSearchRequestDto(String input) {
        List<String> splitInput = List.of(input.split(","));
        if (splitInput.size() != 3) {
            throw new IllegalArgumentException("[ERROR] ...");
        }
        String courseName = splitInput.getFirst();
        String levelName = splitInput.get(1);
        String missionName = splitInput.getLast();

        Course course = Course.fromName(courseName);
        Level level = Level.fromName(levelName);
        Mission mission = Mission.fromName(missionName);

        return new SelectedTargetDto(course, level, mission);
    }
}
