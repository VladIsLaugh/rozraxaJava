package com.wit.vladyslav;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void menu() throws IOException {
        System.out.println("Вітаю, ви в головному меню\n" +
                "1) Показати мої кредити\n" +
                "2) Взяли новий кредит\n" +
                "3) Погасити кредит\n" +
                "Інша клавіша - зберегти та вийти\n");
        Scanner sc = new Scanner(System.in);
        byte num = sc.nextByte();
        switch (num) {
            case 1:
                AllFuncs.printAll();
                AllFuncs.contOrExit();
                break;

            case 2:
                AllFuncs.addNew(AllFuncs.chooseToAdd());
                AllFuncs.contOrExit();
                break;

            case 3:
                AllFuncs.deleteOld(AllFuncs.chooseToDelete());
                AllFuncs.contOrExit();
                break;
            default:
                AllFuncs.saveAndExit();

        }


    }

}
