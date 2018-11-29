package com.wit.vladyslav;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class TakeKredit extends Main{




    public static void getKridit(int num)throws IOException {
        System.out.println("На яку суму вам потрібен кредит?");
        Scanner in = new Scanner(System.in);
        byte sum = in.nextByte();
        FileWriter writer = new FileWriter(Main.GetFN(), true);


        for (int i = 0; i<5; i++){
            Double d = readd(i,0);
            if(sum<d){
                System.out.println("Для вас рекомендований кредит за " + d + " грн на 10 років. Натисніть 1 щоб оформити цей кредит, або іншу клавішу щоб скасувати." );
                byte yesno = in.nextByte();
                if(yesno==1){
                    fileData.add(d);
                    writer.write(d.toString());
                }
                else
                    Menu.menu();
            }
        }


        writer.flush();
        writer.close();
    }

}
