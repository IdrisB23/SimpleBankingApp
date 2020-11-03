package banking.controller;

import banking.Account;
import banking.controller.controllerLogic.ControllerLogic;
import banking.controller.nextControllerComputer.NextControllerComputer;
import banking.model.Model;
import banking.view.View;

import java.util.List;

public class Controller<T> {
    private Model<T> model;
    private View<T> view;
    private NextControllerComputer<T> ncc;
    private List<Controller> nextControllers;
    private ControllerLogic<T> cl;

    public Controller(Model<T> model, View<T> view, ControllerLogic<T> cl, NextControllerComputer<T> ncc, List<Controller> nextControllers) {
        this.model = model;
        this.view = view;
        this.cl = cl;
        this.ncc = ncc;
        this.nextControllers = nextControllers;
    }

    public Model<T> getModel() {
        return model;
    }

    public View<T> getView() {
        return view;
    }

    public ControllerLogic<T> getCl() {
        return cl;
    }

    public NextControllerComputer<T> getNcc() {
        return ncc;
    }

    public void setNcc(NextControllerComputer<T> ncc) {
        this.ncc = ncc;
    }

    public void setModel(Model<T> model) {
        this.model = model;
    }

    public void setView(View<T> view) {
        this.view = view;
    }

    public void setCl(ControllerLogic<T> cl) {
        this.cl = cl;
    }

    public void coordinate() {
        cl.coordinate(model, view, ncc, nextControllers);
    }
}
