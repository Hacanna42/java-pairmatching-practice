package pairmatching;

import java.io.FileNotFoundException;
import pairmatching.controller.PairController;
import pairmatching.domain.Crews;
import pairmatching.service.PairService;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        PairController pairController = new PairController(new PairService());
        try {
            pairController.start();
        } catch (FileNotFoundException exception) {
            System.out.println("[ERROR] resources에서 crew 관련 파일을 찾을 수 없습니다. 프로그램을 종료합니다.");
        }
    }
}
