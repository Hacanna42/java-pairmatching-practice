package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;
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
        // Project Structrue SDK 관련 버그로 인해, Console.readLine() 이 아닌 Java 기본의 Scanner.nextLine()을 사용함.
        System.out.println("과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return Parser.makeSearchRequestDto(input);
    }
}
