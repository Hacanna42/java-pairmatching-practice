package pairmatching.dto;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Pair;
import pairmatching.message.PairMatchingResult;

public record PairMatchingResultDto(PairMatchingResult result, List<Pair> pairs) {

    public static PairMatchingResultDto makeResultFrom(PairMatchingResult result) {
        return new PairMatchingResultDto(result, new ArrayList<>());
    }
}
