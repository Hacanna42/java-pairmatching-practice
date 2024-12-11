package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairStatus {
    private final Map<Mission, MatchedPair> pairStatus;

    private PairStatus(Map<Mission, MatchedPair> pairStatus) {
        this.pairStatus = pairStatus;
    }

    public static PairStatus getInstance() {
        return new PairStatus(new HashMap<>());
    }

    public void clear() {
        pairStatus.clear();
    }

    public boolean isAlreadyMatched(Course course, Mission mission) {
        if (!pairStatus.containsKey(mission)) {
            return false;
        }

        MatchedPair matchedPair = pairStatus.get(mission);
        return matchedPair.isAlreadyMatched(course);
    }

    public MatchedPair getMatchedPairFrom(Mission mission) {
        if (pairStatus.containsKey(mission)) {
            return pairStatus.get(mission);
        }

        pairStatus.put(mission, new MatchedPair(new HashMap<>()));
        return pairStatus.get(mission);
    }

    public boolean hasDuplicatedPairInSameLevel(Course course, Mission mission, List<Pair> tryingPairs) {
        List<List<Pair>> comparePairsList = new ArrayList<>();

        for (Map.Entry<Mission, MatchedPair> entry : pairStatus.entrySet()) {
            Mission currentMission = entry.getKey();
            if (mission.isSameLevel(currentMission) && !currentMission.equals(mission)) {
                comparePairsList.add(entry.getValue().getPairsFrom(course));
            }
        }

        return checkDuplicatedPairBetween(tryingPairs, comparePairsList);
    }

    private boolean checkDuplicatedPairBetween(List<Pair> tryingPairs, List<List<Pair>> comparePairsList) {
        for (List<Pair> comparePairs : comparePairsList) {
            for (Pair comparePair : comparePairs) {
                for (Pair tryingPair : tryingPairs) {
                    if (tryingPair.isSamePair(comparePair)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
