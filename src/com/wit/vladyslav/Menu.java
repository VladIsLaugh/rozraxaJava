package com.wit.vladyslav;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        System.out.println("Вітаю, ви в головному меню" +
                "Мої кредити натисніть 1" +
                "Взяли новий кредит натисніть 2" +
                "Погасити кредит натисніть 3");
        Scanner sc = new Scanner(System.in);
        byte num = sc.nextByte();
        switch (num) {
            case 1:

                break;

            case 2:

                break;

            case 3:

                break;

            default:

                menu();

        }


    }
}