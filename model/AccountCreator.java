package banking.model;

import banking.Account;
import banking.AccountNumberGenerator;
import banking.Main;

import java.util.Random;

public class AccountCreator {
    private AccountNumberGenerator ang;

    public static Account createAccountAndAddAccountList(AccountNumberGenerator ang) {
        Account result = new AccountCreator(ang).createAccount();
        Main.accountList.add(result);
        return result;
    }

    private AccountCreator(AccountNumberGenerator ang) {
        this.ang = ang;
    }

    private Account createAccount() {
        Random rand = new Random();
        int tmp;
        do {
            tmp = rand.nextInt(10000);
        } while(tmp / 1000 == 0);
        return new Account(ang.generate(), tmp);
    }
}
