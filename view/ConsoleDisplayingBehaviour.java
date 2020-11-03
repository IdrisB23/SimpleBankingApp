package banking.view;

public class ConsoleDisplayingBehaviour implements DisplayingBehaviour {
    @Override
    public void display(String str) {
        System.out.println(str);
    }
}
