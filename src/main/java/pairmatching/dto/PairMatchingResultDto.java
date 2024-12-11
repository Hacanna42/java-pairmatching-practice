package pairmatching.dto;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Pair;
import pairmatching.message.PairMatchingResult;

public record PairMatchingResultDto(PairMatchingResult errorMessage, List<Pair> pairs) {

    public static PairMatchingResultDto makeErrorFrom(PairMatchingResult errorMessage) {
        return new PairMatchingResultDto(errorMessage, new ArrayList<>());
    }
}
