package com.wit.vladyslav;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static String fn;

    public static String GetFN() {
        return fn;
    }

    public static void SetFN(String filename) {
        fn = filename;
    }

    public static ArrayList fileData;


    public static void main(String[] args) throws IOException {


        hello();




        Main ch = new Main();
        int num = ch.chooseBank();

        Main b = new Main();

        double chb = b.readd(2, 3);


        TakeKredit gk = new TakeKredit();
        gk.getKridit(num);


    }


    private static void hello() throws IOException {
        System.out.println("Вас вітає программа мій помічник. \n" +
                "Для реєстрації натисніть 1.\n" +
                "Для входу в свій обліковий запис натисніть 2\n" +
                "Спробувати демо версію натисніть 3\n");


        Scanner w = new Scanner(System.in);
        byte menuChoise = w.nextByte();

    }


        public static double readd ( int row, int cell) throws IOException {
            FileInputStream fis = new FileInputStream("C:/Users/Владислав/Desktop/Banking.xls"); // читаю
            Workbook wbi = new HSSFWorkbook(fis);          //обэкт для читання
            double res = wbi.getSheetAt(0).getRow(row).getCell(cell).getNumericCellValue();
            fis.close();
            return res;
        }


        private static int chooseBank () {
            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Ви обрали ПриватБанк.");
                    break;

                case 2:
                    System.out.println("Ви обрали Альфа Банк");
                    break;

                case 3:
                    System.out.println("Ви обрали УкрСибБанк");
                    break;

                default:
                    System.out.println("Невірно набраний номер, Введіть будьласка ще раз");
                    chooseBank();
            }
            return num;
        }


    }




   // File file = new File("C:/Users/Владислав/Desktop/Banking.txt");
    //Scanner scaner = new Scanner(file);
      //  System.out.println(scaner.nextLine());



// Workbook wbo = new HSSFWorkbook();                 // обэкт для запису

// Sheet write = wbo.createSheet("моя вкладка");// створюэмо вкладкy
//Sheet w = wbo.createSheet();

//double res = wbi.getSheetAt(0).getRow(2).getCell(1).getNumericCellValue();
//System.out.println("Вдсоток в приват банку - " + res);

//Row frow1 = w.createRow(7);      //обираэм рядок для запису
//Cell fcell1 = frow1.createCell(7);  //обираэмо комырку для запису
//fcell1.setCellValue("vova");       //записуэмо значення



//FileOutputStream fos = new FileOutputStream("C:/Users/Владислав/Desktop/Banking.xls", true);//запис

// wbo.write(fos);
// fos.close();




/*
        Row frow1 = test.createRow(0);      //обираэм рядок для запису
        Cell fcell1 = frow1.createCell(0);  //обираэмо комырку для запису
        fcell1.setCellValue(123);       //записуэмо значення
*/
        /*
        for (int i = 0; i < 5; i++) {
            String res = wbi.getSheetAt(0).getRow(i).getCell(0).getStringCellValue(); //зчитуэмо значеня
            Row frow1 = test.createRow(i);      //обираэм рядок для запису
            Cell fcell1 = frow1.createCell(0);  //обираэмо комырку для запису
            fcell1.setCellValue(res);       //записуэмо значення
        }
*/