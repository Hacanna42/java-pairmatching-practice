package pairmatching.controller;

import java.io.FileNotFoundException;
import pairmatching.domain.Function;
import pairmatching.domain.Mission;
import pairmatching.dto.PairMatchingResultDto;
import pairmatching.dto.SelectedTargetDto;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    private final PairService pairService;

    public PairController(PairService pairService) {
        this.pairService = pairService;
    }

    public void start() throws FileNotFoundException {
        while (true) {
            Function selectedFunction = InputView.selectFunction();
            run(selectedFunction);
        }
    }

    private void run(Function function) {
        if (function == Function.PAIR_MATCHING) {
            OutputView.printOverallStatus();
            SelectedTargetDto selectedTargetDto = InputView.selectTargetMission();
            PairMatchingResultDto pairMatchingResultDto = pairService.matchingPair(selectedTargetDto);

            return;
        }
        if (function == Function.PAIR_CHECK) {
            return;
        }
        if (function == Function.PAIR_RESET) {
            return;
        }
        if (function == Function.QUIT) {
            return;
        }
    }
}
