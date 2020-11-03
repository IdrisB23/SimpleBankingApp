package banking.view;

public class UpdatingBySettingPromptBehaviour implements UpdatingBehaviour {

    String updateData;

    public UpdatingBySettingPromptBehaviour(String updateData) {
        this.updateData = updateData;
    }

    @Override
    public void update(StringBuilder old, StringBuilder newValue) {
        old = newValue;
    }

    @Override
    public String getUpdateData() {
        return updateData;
    }
}
