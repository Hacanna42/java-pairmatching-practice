package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Function;

public class InputView {
    public static Function selectFunction() {
        System.out.println("기능을 선택하세요.");
        for (Function function : Function.values()) {
            System.out.printf("%s. %s%n", function.getSelectName(), function.getOptionName());
        }

        return Function.getFunctionFrom(Console.readLine());
    }
}
