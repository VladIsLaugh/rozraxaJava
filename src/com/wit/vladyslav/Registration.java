package com.wit.vladyslav;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Registration {
    public static void registr() throws IOException {
        ArrayList fileData = Main.GetFD();

        System.out.println("Введіть будь ласка ваш логін (латиницею)");
        Scanner reg = new Scanner(System.in);
        String name = reg.nextLine();
        fileData.add(name);

        String filename = "rozrah/" + name.toUpperCase() + ".txt";

        if ((new File(filename)).exists()) {
            System.out.println("Ви вже реєструвались під цим логіном");
            registr();
        }

        Main.SetFN(filename);

        System.out.println("Введіть будь ласка ваш пароль");
        String pass = reg.nextLine();
        fileData.add(pass);


        System.out.println("Вітаю, ви зайшли пройшли реєстрацію в інтернет помічнику");

        FileManager.writeInFile();
        Main.SetFD(fileData);

    }

    public static void logIn() throws IOException {

        System.out.println("Введіть ваш логін");
        Scanner scname = new Scanner(System.in);
        String name = scname.nextLine();
        String filename = "C:/Users/Владислав/Desktop/rozrah/" + name.toUpperCase() + ".txt";

        if (!(new File(filename)).exists()) {
            System.out.println("невірний логін");
            logIn();
        }

        Main.SetFN(filename);
        FileManager.writeInArrList();
        ArrayList fileData = Main.GetFD();
        System.out.println("Введіть ваш пароль");
        String pass = scname.nextLine();
        String passdoc = (String) fileData.get(1);

        if (!pass.equals(passdoc)) {
            System.out.println("Невірнй пароль");
            logIn();
        }
        System.out.println("Ви війшли в систему");
    }

    public static void demo() throws IOException {

        int num = 1473;
        String filename = "C:/Users/Владислав/Desktop/rozrah/Demo" + num + ".txt";
        File f = new File(filename);
        while (f.exists()) {
            num += 1;
            filename = "C:/Users/Владислав/Desktop/rozrah/Demo" + num + ".txt";
            f = new File(filename);
        }
        Main.SetFN(filename);
        ArrayList fileData = Main.GetFD();

        fileData.add("Admin");
        fileData.add("Admin");
        FileManager.writeInFile();
        Main.SetFD(fileData);
    }
}
