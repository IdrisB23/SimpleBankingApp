package banking.model.dataComputer;

import banking.Account;
import banking.AccountNumberGenerator;
import banking.Main;

import java.util.Random;

public class AccountCreationDataComputer implements DataComputer<String> {

    AccountNumberGenerator ang;

    public AccountCreationDataComputer(AccountNumberGenerator ang) {
        this.ang = ang;
    }

    @Override
    public String computeData(String s) throws Exception {
        Random rand = new Random();
        int tmp;
        do {
            tmp = rand.nextInt(10000);
        } while(tmp / 1000 == 0);
        Account createdAccount = new Account(ang.generate(), tmp);
        Main.accountList.add(createdAccount);
        return "\nYour card number:\n"+createdAccount.getCardNumber()+"\nYou PIN:\n"+createdAccount.getPin();
    }
}
