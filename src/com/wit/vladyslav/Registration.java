package com.wit.vladyslav;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.Scanner;

public class Registration{
    public static void hello() throws IOException {

        System.out.println("Вас вітає програма мій помічник який допооже вам взяти кредит за найвигіднішими умовами");
        System.out.println("Щоб зареєструватись в помічнику натисніть 1, щоб зайти у свій обліковий запис натисніть 2");
        Scanner i = new Scanner(System.in);
        int w = i.nextInt();
        if(w == 1){
            Registr();
        }
        else if(w == 2){
            LogIn();
        }
        else{
            hello();
        }
        System.out.println("Введіть будь ласка ваше ім'я (латиницею)");

        System.out.println("Оберіть банк. Приват банк натисніть 1, Альфа банк натисніть 2, УкрСиббанк натисніть 3");
    }

    private static void Registr() throws IOException{

        System.out.println("Введіть будь ласка ваш логін (латиницею)");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        String filename = "C:/Users/Владислав/Desktop/rozrah/" + name.toUpperCase()  + ".txt";
        if ((new File(filename)).exists()) {
            System.out.println("Ви вже реєструвались під цим логіном");
            Registr();
        }
        FileWriter writer = new FileWriter(filename, true);
        writer.write(name+ "\r\n");     //записуємо імя

        System.out.println("Введіть будь ласка ваш пароль");
        String pass = in.nextLine();
        writer.write(pass + "\r\n");
        System.out.println("Введіть ваш номер телефону в міжнародному форматі (+380...)");
        String number = in.nextLine();
        writer.write(number + "\r\n");
        System.out.println("Вітаю, ви зайшли пройшли реєстрацію в інтернет помічнику\nТепер потрібно ввійти в систему");
        writer.flush();
        LogIn();
    }

    private static void LogIn() throws IOException {

        System.out.println("Введіть ваш логін");
        Scanner scname = new Scanner(System.in);
        String name = scname.nextLine();
        String filename = "C:/Users/Владислав/Desktop/rozrah/" + name.toUpperCase() + ".txt";


        if (!(new File(filename)).exists()) {
            System.out.println("невірний логін");
            LogIn();
        }


        FileReader reader = new FileReader(filename);
        Scanner scaner = new Scanner(reader);


        System.out.println(scaner.nextLine());

        System.out.println("Введіть ваш пароль");

        String pass = scname.nextLine();

        String passdoc = scaner.nextLine();

        if(!pass.equals(passdoc)){
            System.out.println("Невірний пароль, щоб спробувати ще раз натисніть 1, щоб відновити пароль натисніть 2");
            LogIn();
        }
        System.out.println("Вітаю Ви війшли в систему");
        Main.SetFN(filename);
    }

}

