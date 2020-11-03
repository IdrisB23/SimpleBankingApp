package banking.controller.controllerLogic;

import banking.controller.Controller;
import banking.controller.nextControllerComputer.NextControllerComputer;
import banking.model.Model;
import banking.view.View;

import java.util.List;

public interface ControllerLogic<T> {
    void coordinate(Model<T> model, View<T> view, NextControllerComputer<T> ncc, List<Controller> nextControllers);
}
