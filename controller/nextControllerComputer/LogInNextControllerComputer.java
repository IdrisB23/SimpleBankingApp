package banking.controller.nextControllerComputer;

import banking.Account;
import banking.Main;
import banking.controller.Controller;
import banking.exceptions.WrongCardNumberOrPINException;

import java.util.List;
import java.util.Optional;

public class LogInNextControllerComputer implements NextControllerComputer<String> {
    /**
     *
     * @param s encodes account data: account number and pin are separated by a colon
     * @param nextControllers  contains at least two elements, the first being the account menu and the second main menu
     * @return an Optional object encapsulating the second element of the list argument if account entries are false.
     * Otherwise associates the next menu with the matched account and returns an optional containing this menu.
     * @throws Exception
     */
    @Override
    public Optional<Controller> computeNextController(String s, List<Controller> nextControllers) throws Exception {
        long accountNumber = Long.parseLong(s.split(":")[0]);
        int accountPIN = Integer.parseInt(s.split(":")[1]);
        Account potentialAccount = new Account(accountNumber, accountPIN);
        int potentialIndex = Main.accountList.indexOf(potentialAccount);
        if(potentialIndex != -1 && Main.accountList.get(potentialIndex).getPin() == potentialAccount.getPin()) {
            nextControllers.get(0).getModel().setUserAccount(Main.accountList.get(potentialIndex));
            return Optional.ofNullable(nextControllers.get((0)));
        }
        throw new WrongCardNumberOrPINException();
    }
}
