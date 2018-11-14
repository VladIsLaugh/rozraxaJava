package com.wit.vladyslav;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Main hi = new Main(); String filename = hi.hello();
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        Main ch = new Main(); ch.chooseBank(num);

        Main b =new Main();

        double chb = b.readd(2,3);
        System.out.println(chb);


        Main gk = new Main();
        gk.getKridit(filename, num);






    }
    private static String hello() throws IOException{
        System.out.println("Вас вітає програма мій помічник яка допооже вам взяти кредит за найвигіднішими умовами");
        System.out.println("Введіть будь ласка ваше ім'я (латиницею)");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        String filename = "C:/Users/Владислав/Desktop/rozrah/" + name  + ".txt";
        name  +=   "\r\n";          // перенос на новий рядок
        FileWriter writer = new FileWriter(filename, true);

        writer.write(name);     //записуємо імя

        writer.flush();

        System.out.println("Оберіть банк. Приват банк натисніть 1, Альфа банк натисніть 2, УкрСиббанк натисніть 3");

        return filename;


    }

    private static double readd(int row, int cell) throws IOException {
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



    private static void getKridit(String filename, int num)throws IOException{
        System.out.println("На яку суму вам потрібен кредит?");
        Scanner in = new Scanner(System.in);
        Integer sum = in.nextInt();

        sum.toString();

        FileWriter writer = new FileWriter(filename, true);
        writer.write(sum.toString());     //записуємо імя


        System.out.println("На скільки років берете кредит?");
        int year = in.nextInt();

        double CherezGod = sum + year*sum * readd(2,num+1);
        System.out.println(CherezGod);

        writer.write(CherezGod + "\r\n");
        double vMisyaz = CherezGod / (year*12);
        System.out.println(vMisyaz);
        writer.write(vMisyaz + "\r\n");
        writer.flush();
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