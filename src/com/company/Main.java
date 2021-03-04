/* Домашка 8.4 Создать генератор паролей, который будет генерировать случайные пароли по следующим правилам:
Пароль состоит из 8 символов
В пароле допускаются только латинские большие и маленькие буквы, цифры и символ подчеркивания
Пароль обязательно должен содержать Большие, маленькие буквы и цифры*/

package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static final int lengthPassword = 8;
    public static final int numberAdmissibleChars = 63;
    public static final int asciiNumbersBegin = 48;
    public static final int asciiNumbersEnd = 57;

    public static void main(String[] args) {
        char[] admissibleSymbols = fillAdmissibleSymbol();
        int[] randomIndex = fillRandomIndex();
        char[] password = createPassword(admissibleSymbols, randomIndex);
        System.out.println(Arrays.toString(password) + " - стартовый пароль");
        int indexDigit = findIndexDigit(password);
        if (indexDigit == -1) {
            indexDigit = addDigit(password);
        }
        int indexUpper = indexUpperCase(password, indexDigit);
        if (Arrays.toString(password).equals(Arrays.toString(password).toUpperCase())) {
            addLowerCase(password, indexDigit, indexUpper);
        }
        System.out.println(Arrays.toString(password) + " - итоговый пароль");
    }

    private static char[] fillAdmissibleSymbol() {
        char[] admissibleSymbols = new char[numberAdmissibleChars];
        int maxAsciiIndexes = 122;
        int j = 0;
        for (int i = 0; i <= maxAsciiIndexes; i++) {
            if (i >= 48 & i <= 57 || i == 95 || i >= 65 & i <= 90 || i >= 97) {
                admissibleSymbols[j] = (char) i;
                j = j + 1;
            }
        }
        return admissibleSymbols;
    }

    private static int[] fillRandomIndex() {
        int[] randomPositions = new int[lengthPassword];
        Random random = new Random();
        for (int i = 0; i < lengthPassword; i++) {
            randomPositions[i] = random.nextInt(numberAdmissibleChars);
        }
        return randomPositions;
    }

    private static char[] createPassword(char[] admissibleSymbols, int[] randomIndex) {
        char[] password = new char[lengthPassword];
        int j;
        for (int i = 0; i < lengthPassword; i++) {
            j = randomIndex[i];
            password[i] = admissibleSymbols[j];
        }
        return password;
    }

    private static int findIndexDigit(char[] password) {
        for (int i = 0; i < password.length; i++) {
            if ((int) password[i] > asciiNumbersBegin & (int) password[i] <= asciiNumbersEnd) {
                return i;
            }
        }
        return -1;
    }

    private static int addDigit(char[] password) {
        Random random = new Random();
        int randomIndex = random.nextInt(lengthPassword);
        int numberByIndex = asciiNumbersBegin + random.nextInt(9);
        password[randomIndex] = (char) numberByIndex;
        return randomIndex;
    }

    private static int indexUpperCase(char[] password, int indexDigit) {
        int asciiUpperBegin = 65;
        int asciiUpperEnd = 90;
        int lengthUpper = asciiUpperEnd - asciiUpperBegin + 1;
        String symbol;
        for (int i = 0; i < password.length; i++) {
            if (!(i == indexDigit)) {
                symbol = Character.toString(password[i]);
                if (symbol.equals(symbol.toUpperCase()))
                    return i;
            }
        }
        Random random = new Random();
        int randomIndex = random.nextInt(lengthPassword);
        while (randomIndex == indexDigit) {
            randomIndex = random.nextInt(lengthPassword);
        }
        int numberByIndex = asciiUpperBegin + random.nextInt(lengthUpper);
        password[randomIndex] = (char) numberByIndex;
        return randomIndex;
    }

    private static void addLowerCase(char[] password, int indexDigit, int indexUpper) {
        int asciiLowerBegin = 97;
        int asciiLowerFinish = 122;
        int lengthLower = asciiLowerFinish - asciiLowerBegin + 1;
        Random random = new Random();
        int randomIndex = random.nextInt(lengthPassword);
        while (randomIndex == indexDigit || randomIndex == indexUpper) {
            randomIndex = random.nextInt(lengthPassword);
        }
        int indexAsciiLow = asciiLowerBegin + random.nextInt(lengthLower);
        password[randomIndex] = (char) indexAsciiLow;
    }
}