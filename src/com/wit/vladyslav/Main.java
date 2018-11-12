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

public class Main {

    public static void main(String[] args) throws IOException {
        Main b=new Main();
        b.read();
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

    private static void read() throws IOException {
        FileInputStream fis = new FileInputStream("D:/Рабочий стол/Banking.xls"); // читаю
        Workbook wbi = new HSSFWorkbook(fis);          //обэкт для читання
        double res = wbi.getSheetAt(0).getRow(2).getCell(1).getNumericCellValue();
        System.out.println("Вдсоток в приват банку - " + res);
        fis.close();

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