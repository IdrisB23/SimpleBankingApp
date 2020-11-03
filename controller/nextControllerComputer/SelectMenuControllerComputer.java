package banking.controller.nextControllerComputer;

import banking.controller.Controller;
import banking.exceptions.CommandIndexOutOfBoundException;

import java.util.List;
import java.util.Optional;

public class SelectMenuControllerComputer implements NextControllerComputer<String> {
    @Override
    public Optional<Controller> computeNextController(String str, List<Controller> nextControllers) throws Exception {
        try {
            int commandIndex = Integer.parseInt(str);
            return Optional.ofNullable(nextControllers.get(commandIndex));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new CommandIndexOutOfBoundException();
        }
    }
}
