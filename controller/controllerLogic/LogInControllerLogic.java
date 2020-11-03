package banking.controller.controllerLogic;

import banking.controller.Controller;
import banking.controller.nextControllerComputer.NextControllerComputer;
import banking.exceptions.WrongCardNumberOrPINException;
import banking.model.Model;
import banking.view.View;

import java.util.List;

public class LogInControllerLogic implements ControllerLogic<String> {
    @Override
    public void coordinate(Model<String> model, View<String> view, NextControllerComputer<String> ncc, List<Controller> nextControllers) {
        String accountNumber = view.display().interactWithUser();
        view.update();
        String pin = view.display().interactWithUser();
        try {
            ncc.computeNextController(accountNumber + ":" + pin, nextControllers).ifPresent(c -> {
                view.display("You have successfully logged in!");
                c.coordinate();
            });
        } catch (WrongCardNumberOrPINException e) {
            view.display(e.getMessage());
            nextControllers.get(nextControllers.size()-1).coordinate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
