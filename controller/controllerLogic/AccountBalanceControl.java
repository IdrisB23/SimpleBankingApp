package banking.controller.controllerLogic;

import banking.controller.Controller;
import banking.controller.nextControllerComputer.NextControllerComputer;
import banking.model.Model;
import banking.view.View;

import java.util.List;

public class AccountBalanceControl implements ControllerLogic<String> {
    @Override
    public void coordinate(Model<String> model, View<String> view, NextControllerComputer<String> ncc, List<Controller> nextControllers) {
        view.display().display(""+model.getUserAccount().getBalance());
        try {
            ncc.computeNextController(null, nextControllers).ifPresent(Controller::coordinate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
