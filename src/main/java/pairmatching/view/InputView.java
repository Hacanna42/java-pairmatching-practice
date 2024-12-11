package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Function;
import pairmatching.dto.SelectedTargetDto;
import pairmatching.util.Parser;

public class InputView {
    public static Function selectFunction() {
        System.out.println("기능을 선택하세요.");
        for (Function function : Function.values()) {
            System.out.printf("%s. %s%n", function.getSelectName(), function.getOptionName());
        }

        return Function.getFunctionFrom(Console.readLine());
    }

    public static SelectedTargetDto selectTargetMission() {
        System.out.println("과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주");
        return Parser.makeSearchRequestDto(Console.readLine());
    }

    public static boolean askForceMatching() {
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
        return Console.readLine().equals("네");
    }
}
