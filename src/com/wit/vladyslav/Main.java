package com.wit.vladyslav;

import jdk.nashorn.internal.ir.IfNode;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.util.Scanner;

public class Main {

    private static String fn;

    public static String GetFN(){
        return fn;
    }
    public static void SetFN(String filename){
        fn = filename;
    }
    public static void main(String[] args) throws IOException {
        Registration hi = new Registration();
        hi.hello();
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        Main ch = new Main();
        ch.chooseBank(num);

        Main b =new Main();

        double chb = b.readd(2,3);


        TakeKredit gk = new TakeKredit();
        gk.getKridit(num);


    }


    public static double readd(int row, int cell) throws IOException  {
        FileInputStream fis = new FileInputStream("C:/Users/Владислав/Desktop/Banking.xls"); // читаю
        Workbook wbi = new HSSFWorkbook(fis);          //обэкт для читання
        double res = wbi.getSheetAt(0).getRow(row).getCell(cell).getNumericCellValue();
        fis.close();
        return res;
    }

    private static String reads(int row, int cell) throws IOException {
        FileInputStream fis = new FileInputStream("C:/Users/Владислав/Desktop/Banking.xls"); // читаю
        Workbook wbi = new HSSFWorkbook(fis);          //обэкт для читання
        String res = wbi.getSheetAt(0).getRow(row).getCell(cell).getStringCellValue();
        fis.close();
        return res;
    }

    private static void chooseBank(int a) {
        switch (a) {
            case 1:
                System.out.println("1");
                break;

            case 2:
                System.out.println("2");
                break;

            case 3:
                System.out.println("3");
                break;

            default:
                System.out.println("4");
        }
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