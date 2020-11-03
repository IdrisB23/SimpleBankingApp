package banking.controller.nextControllerComputer;

import banking.controller.Controller;

import java.util.List;
import java.util.Optional;

public class ReturnToArgumentModuleControllerComputer implements NextControllerComputer<String> {

    @Override
    public Optional<Controller> computeNextController(String s, List<Controller> nextControllers) throws Exception {
        return Optional.ofNullable(nextControllers.get(0));
    }
}
