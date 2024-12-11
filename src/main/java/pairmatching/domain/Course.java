package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getStringValues() {
        List<String> courses = new ArrayList<>();
        for (Course course : Course.values()) {
            courses.add(course.getName());
        }

        return courses;
    }

    public static Course fromName(String name) {
        for (Course course : Course.values()) {
            if (course.name.equals(name)) {
                return course;
            }
        }
        throw new IllegalArgumentException("Course를 찾을 수 없습니다.");
    }

    public boolean isBackend() {
        return this == Course.BACKEND;
    }
}