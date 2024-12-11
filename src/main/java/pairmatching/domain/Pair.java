package pairmatching.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {
    private final List<Crew> pair;

    public Pair(List<Crew> pair) {
        this.pair = pair;
    }

    public void addCrew(Crew crew) {
        pair.add(crew);
    }

    public boolean isSamePair(Pair pair) {
        return new HashSet<>(this.pair).equals(new HashSet<>(pair.pair));
    }

    @Override
    public String toString() {
        return pair.stream()
                .map(Crew::toString)
                .collect(Collectors.joining(" : "));
    }
}
