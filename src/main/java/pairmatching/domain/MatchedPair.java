package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatchedPair {
    private final Map<Course, List<Pair>> matchedPairs;

    public MatchedPair(Map<Course, List<Pair>> matchedPairs) {
        this.matchedPairs = matchedPairs;
    }

    public boolean isAlreadyMatched(Course course) {
        return matchedPairs.containsKey(course);
    }

    public void addPair(Course course, List<Pair> pairs) {
        matchedPairs.put(course, pairs);
    }

    public List<Pair> getPairsFrom(Course course) {
        if (matchedPairs.containsKey(course)) {
            return matchedPairs.get(course);
        }

        return new ArrayList<>();
    }
}
