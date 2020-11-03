package banking.model;

import banking.Account;
import banking.controller.Controller;
import banking.model.dataComputer.DataComputer;

import java.util.List;

public class Model<T> {
    private DataComputer<T> dc;
    private List<Controller> nextControllers;
    private Account userAccount;

    public Model(DataComputer<T> dc, List<Controller> nextControllers) {
        this.dc = dc;
        this.nextControllers = nextControllers;
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public DataComputer<T> getDc() {
        return dc;
    }

    public void setDc(DataComputer<T> dc) {
        this.dc = dc;
    }

    public List<Controller> getNextControllers() {
        return nextControllers;
    }

    public void setNextControllers(List<Controller> nextControllers) {
        this.nextControllers = nextControllers;
    }

    public void setUserAccount(Account userAcc) {
        this.userAccount = userAcc;
    }

    public T computeData(T s) throws Exception {
        return dc.computeData(s);
    }
}
