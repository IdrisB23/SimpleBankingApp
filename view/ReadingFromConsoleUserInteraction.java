package banking.view;

import java.util.Scanner;

public class ReadingFromConsoleUserInteraction implements UserInteractionBehaviour<String> {
    @Override
    public String interactWithUser() {
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        sc.close();
        return result;
    }
}
