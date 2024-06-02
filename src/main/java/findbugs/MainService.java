package findbugs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Service class that uses the ExternalSystem
public class MainService {
    private ExternalSystem externalSystem;
    private List<String> list;

    // ExternalSystem is injected via the constructor
    public MainService(ExternalSystem externalSystem, List<String> list) {
        this.externalSystem = externalSystem;
        this.list = new ArrayList<>(list);
    }

    public void performAction() {
        // Use the externalSystem reference to call mutateState
        this.externalSystem.mutateState();
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }

    public static void main(String[] args) {
        // Create a new MainService with a new ExternalSystem
        List<String> list = new ArrayList<>();
        list.add("Hello");
        MainService mainService = new MainService(new ExternalSystem(), list);
        List<String> list2 = mainService.getList();
        list2.add("World");
    }
}
