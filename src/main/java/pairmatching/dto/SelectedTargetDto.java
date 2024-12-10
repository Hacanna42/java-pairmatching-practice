package pairmatching.dto;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public record SelectedTargetDto(Course course, Level level, Mission mission) {
}
