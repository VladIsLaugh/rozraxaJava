package com.wit.vladyslav;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TakeKredit extends Main{
    public static void getKridit(int num)throws IOException {
        System.out.println("На яку суму вам потрібен кредит?");
        Scanner in = new Scanner(System.in);
        Integer sum = in.nextInt();

        //Main.Get();
        sum.toString();

        FileWriter writer = new FileWriter(Main.GetFN(), true);
        writer.write(sum.toString());     //записуємо імя


        System.out.println("На скільки років берете кредит?");
        int year = in.nextInt();

        double CherezGod = sum + year*sum * readd(2,num+1);
        System.out.println("Сума яку потрібно буде віддати:  " + (double)Math.round(CherezGod * 100d) / 100d + " грн");

        writer.write(CherezGod + "\r\n");
        double vMisyaz = CherezGod / (year*12);
        System.out.println("Сума яку треба сплачувати щомісяця:  " + (double)Math.round(vMisyaz * 100d) / 100d + " грн");
        writer.write(vMisyaz + "\r\n");
        writer.flush();
        writer.close();
    }

}
