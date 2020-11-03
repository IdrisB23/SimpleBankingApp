package banking.view;

import java.util.Optional;

public class View<T> {
    private StringBuilder promptMsg;
    private UpdatingBehaviour ub;
    private Optional<T> input;
    private DisplayingBehaviour db;
    private UserInteractionBehaviour<T> uib;
    
    public View(String promptMsg, UpdatingBehaviour ub, DisplayingBehaviour db, UserInteractionBehaviour<T> uib) {
        this.promptMsg = new StringBuilder(promptMsg);
        this.ub = ub;
        this.db = db;
        this.uib = uib;
    }
    
    public View<T> display() {
        db.display(promptMsg.toString());
        return this;
    }
    public View<T> display(String str) {
        db.display(str);
        return this;
    }
    public T interactWithUser() {
        return uib.interactWithUser();
    }

    public void update() {
        ub.update(promptMsg, new StringBuilder(ub.getUpdateData()));
    }

    public void setPromptMsg(StringBuilder promptMsg) {
        this.promptMsg = promptMsg;
    }

    public Optional<T> getInput() {
        return input;
    }
}
