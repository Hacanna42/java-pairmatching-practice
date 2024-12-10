package pairmatching.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class CrewInitializer {
    public static List<Crew> getBackendCrews() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/backend-crew.md"));
        List<Crew> backendCrews = new ArrayList<>();
        while (scanner.hasNext()) {
            String name = scanner.nextLine();
            backendCrews.add(new Crew(Course.BACKEND, name));
        }

        return backendCrews;
    }

    public static List<Crew> getFrontendCrews() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/frontend-crew.md"));
        List<Crew> frontendCrews = new ArrayList<>();
        while (scanner.hasNext()) {
            String name = scanner.nextLine();
            frontendCrews.add(new Crew(Course.FRONTEND, name));
        }

        return frontendCrews;
    }
}
