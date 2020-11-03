package banking.controller.controllerLogic;

import banking.controller.Controller;
import banking.controller.nextControllerComputer.NextControllerComputer;
import banking.model.Model;
import banking.view.View;

import java.util.List;
import java.util.Optional;

public class ComputeAndDisplayDataControllerLogic implements ControllerLogic<String> {
    @Override
    public void coordinate(Model<String> model, View<String> view, NextControllerComputer<String> ncc, List<Controller> nextControllers) {
        try {
            view.display().display(model.computeData(null));
            Optional<Controller> nextController = ncc.computeNextController(null, nextControllers);
            if(nextController.isPresent())
                nextController.get().coordinate();
            else
                view.display("Bye!");
        } catch (Exception e) {
            view.display(e.getMessage());
        }
    }
}
