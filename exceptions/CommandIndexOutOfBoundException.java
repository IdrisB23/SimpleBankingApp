package banking.exceptions;

public class CommandIndexOutOfBoundException extends Exception {
    public CommandIndexOutOfBoundException() {
        super("Oops! The number you've entered doesn't correspond to any of the commands above. Please try again.");
    }
}
