package com.wit.vladyslav;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    private static String excelFilePath = "Banking.xls";

    public static double read (int cell, int row) throws IOException {
        FileInputStream fis = new FileInputStream(excelFilePath); // читаю
        Workbook wbi = new HSSFWorkbook(fis);          //обэкт для читання
        double res = wbi.getSheetAt(0).getRow(row).getCell(cell).getNumericCellValue();
        fis.close();
        return res;
    }

    public static void writeInFile() throws IOException{
        String filename = Main.GetFN();
        ArrayList fileData = Main.GetFD();
        FileWriter writer = new FileWriter(filename, false);
        for(int i = 0; i < fileData.size(); i++) {
            writer.write(fileData.get(i) + "\r\n");
        }
        writer.flush();
        writer.close();

    }

    public static void writeInArrList() throws IOException {
        String filename = Main.GetFN();
        ArrayList fileData = Main.GetFD();


        FileReader reader = new FileReader(filename);
        Scanner scaner = new Scanner(reader);

        for(int i = 0; scaner.hasNextLine(); i++) {
            fileData.add(scaner.nextLine());
        }


        Main.SetFD(fileData);
        scaner.close();
        reader.close();

    }

}
