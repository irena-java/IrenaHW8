/*Домашка 8.1) В банк положили S денег. Какой станет сумма вклада через N лет,
если процент 1,5% добавляется к сумме вклада ежемесячно*/

package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму депозита:");
        double deposit = scanner.nextDouble();
        System.out.println("Введите количество лет:");
        int years = scanner.nextInt();
        double interestRates = 0.015;
        for (int i = 1; i <= years; i++) {
            deposit = capitalizationProcents(deposit, interestRates);
        }
        System.out.printf("Сумма депозита с наращенными процентами: %.2f\n", deposit);
    }

    private static double capitalizationProcents(double deposit, double interestRates) {
        for (int month = 1; month <= 12; month++) {
            deposit = deposit * (1 + interestRates);
        }
        return deposit;
    }
}