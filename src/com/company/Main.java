/*Домашка 8.3*) Написать метод.
Входящий параметр:
Строка со словами разделенными пробелом которые состоят из больших и маленьких букв.
Метод должен вернуть ту же строку в которой первая буква в каждом слове большая, а остальные маленькие*/

package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = scanner.nextLine();
        System.out.println(txtWithBigLetter(text));
    }

    private static String txtWithBigLetter(String text) {
        String[] wordsArr = text.split(" ");
        String changedText = "";
        String nextWord;
        for (int i = 0; i < wordsArr.length; i++) {
            nextWord = bigLetter(wordsArr[i].toLowerCase());
            changedText = changedText.concat(nextWord).concat(" ");
        }
        return eraseLastSpase(changedText);
    }

    private static String bigLetter(String word) {
        String firstLetter;
        firstLetter = word.substring(0, 1).toUpperCase();
        return firstLetter + word.substring(1);
    }

    private static String eraseLastSpase(String txt) {
        txt = txt.substring(0, txt.length() - 1);
        return txt;
    }
}