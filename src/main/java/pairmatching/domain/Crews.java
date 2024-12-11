package pairmatching.domain;

import java.io.FileNotFoundException;
import java.util.List;
import pairmatching.util.CrewInitializer;

public class Crews {
    private final List<Crew> backendCrews;
    private final List<Crew> frontendCrews;

    private Crews(List<Crew> backendCrews, List<Crew> frontendCrews) {
        this.backendCrews = backendCrews;
        this.frontendCrews = frontendCrews;
    }

    public static Crews initCrews() throws FileNotFoundException {
        List<Crew> backendCrews = CrewInitializer.getBackendCrews();
        List<Crew> frontendCrews = CrewInitializer.getFrontendCrews();
        return new Crews(backendCrews, frontendCrews);
    }

    public List<Crew> getCrewsFrom(Course course) {
        if (course.isBackend()) {
            return backendCrews;
        }
        return frontendCrews;
    }
}
