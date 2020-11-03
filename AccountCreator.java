package banking;

import java.util.Random;

public class AccountCreator {
    public AccountCreator() {
        Main.accountList.add(createAccount());
    }

    private Account createAccount() {
        Random rand = new Random();
        String accountNumberStr = "400000";
        Account result;
        do {
            for(int i = 0; i<10; i++) {
                accountNumberStr += rand.nextInt(10);
            }
            result = new Account(Long.parseLong(accountNumberStr), rand.nextInt(10000));
        } while (Main.accountList.contains(result));
        return result;
    }
}
