package banking.controller.controllerLogic;

import banking.controller.Controller;
import banking.controller.nextControllerComputer.NextControllerComputer;
import banking.model.Model;
import banking.view.View;

import java.util.List;
import java.util.Optional;

public class SelectMenuControllerLogic implements ControllerLogic<String> {

    @Override
    public void coordinate(Model<String> model, View<String> view, NextControllerComputer<String> ncc, List<Controller> nextControllers) {
        Optional<Controller> nextController;
        try {
            nextController = ncc.computeNextController(view.display().interactWithUser(), nextControllers);
            if (nextController.isPresent()) {
                nextController.get().coordinate();
            } else
                view.display("Bye!");
        } catch (Exception e) {
            view.display(e.getMessage());
            coordinate(model, view, ncc, nextControllers);
        }
    }
}
