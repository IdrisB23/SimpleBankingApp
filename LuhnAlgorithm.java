package banking;

import java.util.Arrays;
import java.util.Random;

public class LuhnAlgorithm implements AccountNumberGenerator {
    Random rand = new Random();
    @Override
    public long generate() {
        char[] accountNumberAsCharArr = generateRandomUniqueAccountNumber().toCharArray();
        char[] accNumberLuhnProbe = Arrays.copyOf(accountNumberAsCharArr, accountNumberAsCharArr.length);
        multiplyOddArrayIndicesByTwoAndTakeModuloNine(accNumberLuhnProbe);
        int sumOfDigits = 0;
        for (char c : accNumberLuhnProbe) {
            sumOfDigits += Character.getNumericValue(c);
        }
        if (sumOfDigits % 10 == 0) {
            return Long.parseLong(new String(accountNumberAsCharArr) + "0");
        }
        return Long.parseLong(new String(accountNumberAsCharArr) + (10 - sumOfDigits % 10));
    }

    private String generateRandomUniqueAccountNumber() {
        StringBuilder accountNumberStr = new StringBuilder();
        Account tmp;
        do {
            accountNumberStr.append("400000");
            for(int i = 0; i<9; i++) {
                accountNumberStr.append(rand.nextInt(10));
            }
            tmp = new Account(Long.parseLong(accountNumberStr.toString()), rand.nextInt(10000));
        } while (Main.accountList.contains(tmp));
        return accountNumberStr.toString();
    }

    private void multiplyOddArrayIndicesByTwoAndTakeModuloNine(char[] arr) {
        boolean isOdd = true;
        for(int i = 0; i <arr.length; i++) {
            if(isOdd)
                arr[i] = Character.forDigit(Character.getNumericValue(arr[i]) * 2 > 9?
                        Character.getNumericValue(arr[i]) * 2 - 9:
                        Character.getNumericValue(arr[i]) * 2,
                        10);
            isOdd = !isOdd;
        }
    }
}
