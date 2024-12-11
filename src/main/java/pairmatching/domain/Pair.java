package pairmatching.domain;

import java.util.HashSet;
import java.util.List;

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
}
