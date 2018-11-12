package com.wit.vladyslav;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.stream.FileImageOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Main hi = new Main(); hi.hello();

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        Main ch = new Main(); ch.chooseBank(num);

        Main b =new Main();
        System.out.println(b.readd(2,3));
        //Workbook wbo = new HSSFWorkbook();                 // обэкт для запису


        //Sheet write = wbo.createSheet("моя вкладка");// створюэмо вкладка

        //double res = wbi.getSheetAt(0).getRow(2).getCell(1).getNumericCellValue();
        //System.out.println("Вдсоток в приват банку - " + res);

        //Row frow1 = write.createRow(0);      //обираэм рядок для запису
        //Cell fcell1 = frow1.createCell(0);  //обираэмо комырку для запису
        //fcell1.setCellValue(res);       //записуэмо значення



        //FileOutputStream fos = new FileOutputStream("D:/Рабочий стол/my.xls");//запис

        //wbo.write(fos);
        //fos.close();

    }
    private static void hello(){
        System.out.println("Вас вітає програма мій помічник яка допооже вам взяти кредит за найвигіднішими умовами");
        System.out.println("Щоб дізнатись детальніше про приват банк натисніть 1, щоб дізнатись делатьніше про альфа банк натисніть 2, щобб дізнатьсь про укрсиббаннк натисніть 3");

    }

    private static double readd(int row, int cell) throws IOException {
        FileInputStream fis = new FileInputStream("D:/Рабочий стол/Banking.xls"); // читаю
        Workbook wbi = new HSSFWorkbook(fis);          //обэкт для читання
        double res = wbi.getSheetAt(0).getRow(row).getCell(cell).getNumericCellValue();
        fis.close();
        return res;
    }

    private static String reads(int row, int cell) throws IOException {
        FileInputStream fis = new FileInputStream("D:/Рабочий стол/Banking.xls"); // читаю
        Workbook wbi = new HSSFWorkbook(fis);          //обэкт для читання
        String res = wbi.getSheetAt(0).getRow(row).getCell(cell).getStringCellValue();
        fis.close();
        return res;
    }

    private static void chooseBank(int a) {
        switch (a) {
            case 1:
                System.out.println("");
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