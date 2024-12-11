package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.MatchedPair;
import pairmatching.domain.Pair;
import pairmatching.domain.PairStatus;
import pairmatching.domain.Mission;
import pairmatching.dto.PairMatchingResultDto;
import pairmatching.dto.SelectedTargetDto;
import pairmatching.message.PairMatchingResult;

public class PairService {
    private final Crews crews;
    private final PairStatus pairStatus;

    public PairService() throws FileNotFoundException {
        this.crews = Crews.initCrews();
        this.pairStatus = PairStatus.getInstance();
    }

    public PairMatchingResultDto matchingPair(SelectedTargetDto selectedTargetDto) {
        Course targetCourse = selectedTargetDto.course();
        Mission targetMission = selectedTargetDto.mission();
        List<Crew> targetCrews = crews.getCrewsFrom(targetCourse);

        if (pairStatus.isAlreadyMatched(targetCourse, targetMission)) {
            return PairMatchingResultDto.makeErrorFrom(PairMatchingResult.IS_ALREADY_MATCHED);
        }

        return processPairMatching(targetCourse, targetMission, targetCrews);
    }

    private PairMatchingResultDto processPairMatching(Course course, Mission mission, List<Crew> crews) {
        List<Pair> pairs;
        int tryCount = 0;
        do {
            tryCount++;
            if (tryCount > 3) {
                return PairMatchingResultDto.makeErrorFrom(PairMatchingResult.FAILED_MATCHING);
            }
            pairs = getPairs(Randoms.shuffle(crews));
        } while (pairStatus.hasDuplicatedPairInSameLevel(course, mission, pairs));

        MatchedPair matchedPair = pairStatus.getMatchedPairFrom(mission);
        matchedPair.addPair(course, pairs);
        return new PairMatchingResultDto(PairMatchingResult.SUCCESS, pairs);
    }

    private List<Pair> getPairs(List<Crew> shuffledCrews) {
        List<Pair> pairs = new ArrayList<>();
        List<Crew> pair = new ArrayList<>();

        for (Crew crew : shuffledCrews) {
            pair.add(crew);
            if (pair.size() == 2) {
                pairs.add(new Pair(pair));
                pair = new ArrayList<>();
            }
        }

        if (!pair.isEmpty()) {
            Pair lastPair = pairs.getLast();
            for (Crew crew : pair) {
                lastPair.addCrew(crew);
            }
        }

        return pairs;
    }
}
