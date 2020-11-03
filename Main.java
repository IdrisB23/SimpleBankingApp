package banking;

import banking.controller.controllerLogic.*;
import banking.controller.Controller;
import banking.model.Model;
import banking.model.dataComputer.AccountCreationDataComputer;
import banking.model.dataComputer.DataComputer;
import banking.model.dataComputer.MainDataComputer;
import banking.controller.nextControllerComputer.LogInNextControllerComputer;
import banking.controller.nextControllerComputer.SelectMenuControllerComputer;
import banking.controller.nextControllerComputer.NextControllerComputer;
import banking.controller.nextControllerComputer.ReturnToArgumentModuleControllerComputer;
import banking.view.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Account> accountList = new ArrayList<>();
    public static void main(String[] args) {
        // Main Module configuration
        List<Controller> nextControllersMain = new ArrayList<>();
        NextControllerComputer<String> selectMenuNCC = new SelectMenuControllerComputer();
        DataComputer<String> mainDc = new MainDataComputer();
        Model<String> mainModel = new Model<>(mainDc, nextControllersMain);
        AccountNumberGenerator ang = new LuhnAlgorithm();
        String mainViewPrompt = "\n1. Create an account\n2. Log into account\n0. Exit\n";
        DisplayingBehaviour consoleDB = new ConsoleDisplayingBehaviour();
        UserInteractionBehaviour<String> consoleUIB = new ReadingFromConsoleUserInteraction();
        UpdatingBehaviour setUB = new UpdatingBySettingPromptBehaviour(null);
        View<String> mainView = new View<>(mainViewPrompt, setUB, consoleDB, consoleUIB);
        ControllerLogic<String> selectMenuCL = new SelectMenuControllerLogic();
        Controller<String> mainController = new Controller<>
                (mainModel, mainView, selectMenuCL, selectMenuNCC, nextControllersMain);
        // Account Creation Module configuration
        DataComputer<String> accountCreationDataComputer = new AccountCreationDataComputer(ang);
        NextControllerComputer<String> accountCreationNCC = new ReturnToArgumentModuleControllerComputer();
        List<Controller> nextControllersAccountCreation = new ArrayList<>();
        Model<String> accCreationModel = new Model<>(accountCreationDataComputer, nextControllersAccountCreation);
        String accountCreationPrompt = "Your card has been created\n";
        View<String> accCreationView = new View<>(accountCreationPrompt, setUB, consoleDB, consoleUIB);
        ControllerLogic<String> computeAndDisplayDataCL = new ComputeAndDisplayDataControllerLogic();
        Controller<String> accCreationController = new Controller<>
                (accCreationModel, accCreationView, computeAndDisplayDataCL, accountCreationNCC, nextControllersAccountCreation);
        // LogIn Module configuration
        NextControllerComputer<String> logInNCC = new LogInNextControllerComputer();
        List<Controller> nextControllersLogIn = new ArrayList<>();
        Model<String> logInModel = new Model<>(null, nextControllersLogIn);
        String logInFirstPrompt = "Enter your card number:";
        String logInSecondPrompt = "Enter you PIN:";
        UpdatingBehaviour updatingBySettingPromptUB = new UpdatingBySettingPromptBehaviour(logInSecondPrompt);
        View<String> logInView = new View<>(logInFirstPrompt, updatingBySettingPromptUB, consoleDB, consoleUIB);
        ControllerLogic<String> logInCL = new LogInControllerLogic();
        Controller<String> logInController = new Controller<>(logInModel, logInView, logInCL, logInNCC, nextControllersLogIn);
        // Account Menu Module configuration
        List<Controller> nextControllersAccount = new ArrayList<>();
        Model<String> accountModel = new Model<>(null, nextControllersAccount);
        String accountPrompt = "\n1. Balance\n2. Log Out\n0. Exit\n";
        View<String> accountView = new View<>(accountPrompt, setUB, consoleDB, consoleUIB);
        Controller<String> accountController = new Controller<>
                (accountModel, accountView, selectMenuCL, selectMenuNCC, nextControllersAccount);
        // Balance Module configuration
        List<Controller> nextControllersBalance = new ArrayList<>();
        String balancePrompt = "Balance:";
        View<String> balanceView = new View<>(balancePrompt, setUB, consoleDB, consoleUIB);
        ControllerLogic<String> balanceCL = new AccountBalanceControl();
        Controller<String> balanceController = new Controller<>
                (accountModel, balanceView, balanceCL, accountCreationNCC, nextControllersBalance);
        // Balance Module initialization
        nextControllersBalance.add(accountController);
        // Account Menu Module initialization
        nextControllersAccount.add(null);
        nextControllersAccount.add(balanceController);
        nextControllersAccount.add(mainController);
        // Account Creation Module initialization
        nextControllersAccountCreation.add(mainController);
        // LogIn Module initialization
        nextControllersLogIn.add(accountController);
        nextControllersLogIn.add(mainController);
        // Main module initialization
        nextControllersMain.add(null);
        nextControllersMain.add(accCreationController);
        nextControllersMain.add(logInController);
        mainController.coordinate();
    }
}