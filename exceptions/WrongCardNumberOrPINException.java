package banking.exceptions;

public class WrongCardNumberOrPINException extends Exception {
    public WrongCardNumberOrPINException() {
        super("Wrong Card number or PIN!");
    }
}
