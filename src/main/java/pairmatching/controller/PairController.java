package pairmatching.controller;

import java.io.FileNotFoundException;
import pairmatching.domain.Function;
import pairmatching.dto.PairMatchingResultDto;
import pairmatching.dto.SelectedTargetDto;
import pairmatching.message.PairMatchingResult;
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
            Function selectedFunction = getSelectedFunction();
            if (selectedFunction.equals(Function.QUIT)) {
                break;
            }
            run(selectedFunction);
        }
    }

    private static Function getSelectedFunction() {
        while (true) {
            try {
                return InputView.selectFunction();
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void run(Function function) {
        if (function == Function.PAIR_MATCHING) {
            processPairMatching();
            return;
        }
        if (function == Function.PAIR_CHECK) {
            processCheckPair();
            return;
        }
        if (function == Function.PAIR_RESET) {
            processClearPair();
            return;
        }
    }

    private void processPairMatching() {
        OutputView.printOverallStatus();
        SelectedTargetDto selectedTargetDto = getSelectedTargetDto();
        PairMatchingResultDto pairMatchingResultDto = pairService.matchingPair(selectedTargetDto, false);
        if (pairMatchingResultDto.result().equals(PairMatchingResult.IS_ALREADY_MATCHED)) {
            if (!askForceMatching()) {
                return;
            }
            pairMatchingResultDto = pairService.matchingPair(selectedTargetDto, true);
        }

        if (pairMatchingResultDto.result().equals(PairMatchingResult.FAILED_MATCHING)) {
            System.out.println("매칭을 할 수 없습니다. 오류 메시지 출력");
            return;
        }

        OutputView.printMatchingResult(pairMatchingResultDto.pairs());
    }

    private static SelectedTargetDto getSelectedTargetDto() {
        while (true) {
            try {
                return InputView.selectTargetMission();
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void processCheckPair() {
        OutputView.printOverallStatus();
        SelectedTargetDto selectedTargetDto = getSelectedTargetDto();
        PairMatchingResultDto pairMatchingResultDto = pairService.checkPair(selectedTargetDto);

        if (pairMatchingResultDto.result().equals(PairMatchingResult.SUCCESS)) {
            OutputView.printMatchingResult(pairMatchingResultDto.pairs());
            return;
        }

        OutputView.printErrorMessage(pairMatchingResultDto.result().getMessage());
    }

    private void processClearPair() {
        pairService.clearPairStatus();
        OutputView.printClearPairMessage();
    }

    private boolean askForceMatching() {
        return InputView.askForceMatching();
    }
}
