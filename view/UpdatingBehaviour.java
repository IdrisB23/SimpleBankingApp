package banking.view;

public interface UpdatingBehaviour {
    void update(StringBuilder oldValue, StringBuilder newValue);
    String getUpdateData();
}
