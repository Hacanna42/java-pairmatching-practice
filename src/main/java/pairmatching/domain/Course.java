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
}