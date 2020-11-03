package banking.controller.nextControllerComputer;

import banking.controller.Controller;

import java.util.List;
import java.util.Optional;

public interface NextControllerComputer<T> {
    Optional<Controller> computeNextController(T t, List<Controller> nextControllers) throws Exception;
}
