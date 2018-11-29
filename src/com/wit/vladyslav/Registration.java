package com.wit.vladyslav;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registration extends Main{


    public static void registr() throws IOException{

        System.out.println("Введіть будь ласка ваш логін (латиницею)");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        fileData.add(name);
        String filename = "C:/Users/Владислав/Desktop/rozrah/" + name.toUpperCase()  + ".txt";
        if ((new File(filename)).exists()) {
            System.out.println("Ви вже реєструвались під цим логіном");
            registr();
        }
        FileWriter writer = new FileWriter(filename, true);
        writer.write(name+ "\r\n");     //записуємо імя

        System.out.println("Введіть будь ласка ваш пароль");
        String pass = in.nextLine();
        fileData.add(pass);
        writer.write(pass + "\r\n");
        System.out.println("Введіть ваш номер телефону в міжнародному форматі (+380...)");
        String number = in.nextLine();
        fileData.add(number);
        writer.write(number + "\r\n");
        System.out.println("Вітаю, ви зайшли пройшли реєстрацію в інтернет помічнику\nТепер потрібно ввійти в систему");
        writer.flush();
        logIn();
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


        FileReader reader = new FileReader(filename);
        Scanner scaner = new Scanner(reader);


        System.out.println(scaner.nextLine());

        System.out.println("Введіть ваш пароль");

        String pass = scname.nextLine();

        String passdoc = scaner.nextLine();

        if(!pass.equals(passdoc)){
            System.out.println("Невірнй пароль");
            logIn();
        }
        System.out.println("Вітаю Ви війшли в систему");
        Main.SetFN(filename);
       // BufferedReader readerr = new BufferedReader(new FileReader(filename);
        String line;
        List<String> lines = new ArrayList<String>();
        while (scaner.nextLine() != null) {
            fileData.add(scaner.nextLine());
        }
    }

    public static void demo(){
        int num = 1473;
        String fName = "Demo" + num + ".txt";
        File f = new File(fName);
        if(!f.isFile()) {
            System.out.println("2");
            demo();

        }
        System.out.println("1");
    }

}

