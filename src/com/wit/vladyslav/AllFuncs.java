package com.wit.vladyslav;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AllFuncs {
    public static void helloUser() throws IOException {
        System.out.println("Вас вітає программа мій помічник. \n" +
                "1) Зареєструватись\n" +
                "2) Увійти\n" +
                "3) Спробувати демо-версію\n");

        Scanner w = new Scanner(System.in);
        byte menuChoise = w.nextByte();
        switch (menuChoise) {
            case 1:
                Registration.registr();
                break;

            case 2:
                Registration.logIn();
                break;

            case 3:
                Registration.demo();
                break;

            default:
                helloUser();
        }
    }

    public static void printAll() {
        ArrayList fd = Main.GetFD();
        if (fd.size()<3)
            System.out.println("У вас немає кредитів для погашення");
        else {
            for (int i = 2; i < fd.size(); i++) {
                System.out.println(fd.get(i));
            }
        }

    }

    public static int chooseToAdd() throws IOException {
        FileManager fm = new FileManager();
        System.out.println("Можливі кредити для вас: ");
        for (int i=0; i<5; i++){
            System.out.println((i+1) + ")" + fm.read(1, i) + "грн");
        }
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        return a;
    }


    public static void addNew(int newKred) throws IOException {
        ArrayList fileData = Main.GetFD();
        if (newKred > 5) {
            System.out.println("Кредит не додано");
            Menu.menu();
        }
        else {
            fileData.add(FileManager.read(1, newKred - 1));
            Main.SetFD(fileData);
            FileManager.writeInFile();
            Main.SetFD(fileData);
        }
    }

    public static int chooseToDelete(){
        ArrayList fileData = Main.GetFD();
        System.out.println("Ваші кредити: ");
        for (int i=0; i<fileData.size()-2; i++){
            System.out.println((i+1) + ")" + fileData.get(i+2) + "грн");
        }
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        return a;
    }

    public static void deleteOld(int oldKred) throws IOException {
        ArrayList fileData = Main.GetFD();
        if (oldKred > fileData.size()){
            System.out.println("Кредит не видалено");
            Menu.menu();
        }
        else {
            fileData.remove(fileData.get(oldKred - 1));
            Main.SetFD(fileData);
            FileManager.writeInFile();
        }
    }


    public static void contOrExit() throws IOException {
        System.out.println("\n Натисніть 1 щоб продовжити\nІншу клавішу для виходу");
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        if (a ==1)
            Menu.menu();
        else
            saveAndExit();

    }


    public static void sort() {
        //sort
    }
    public static void saveAndExit() throws IOException {
        FileManager.writeInFile();
    }

}
