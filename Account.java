package banking;

import java.util.Objects;

public class Account {
    private long cardNumber;
    private int pin;

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    private long balance;

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Account(long cardNumber, int pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        balance = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return cardNumber == account.cardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, pin);
    }

    @Override
    public String toString() {
        return "Account{" +
                "cardNumber=" + cardNumber +
                ", pin=" + pin +
                '}';
    }
}
