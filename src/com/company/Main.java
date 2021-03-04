/*Домашка 8.2) Вывести в 1 строку через пробел все числа от 1 до 99 со следующими изменениями:
- если число кратно 3 то вывести вместо него Hello
- если число кратно 5 то вывести вместо него World
- если число кратно и 3 и 5 то вывести вместо него HelloWorld*/

package com.company;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 99; i++) {
            if (isMuliple(i, 3) & isMuliple(i, 5)) {
                System.out.printf(" HelloWorld");
            } else if (isMuliple(i, 3)) {
                System.out.printf(" Hello");
            } else if (isMuliple(i, 5)) {
                System.out.printf(" World");
            } else {
                System.out.printf(" " + i);
            }
        }
    }

    private static boolean isMuliple(int numbers, int divider) {
        if (numbers % divider == 0) {
            return true;
        } else {
            return false;
        }
    }
}