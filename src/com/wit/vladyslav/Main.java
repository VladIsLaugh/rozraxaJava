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

    public static String fn;

    public static void main(String[] args) throws IOException {
        Main hi = new Main();
        hi.hello();
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        Main ch = new Main();
        ch.chooseBank(num);

        Main b =new Main();

        double chb = b.readd(2,3);
        System.out.println(chb);


        Main gk = new Main();
        gk.getKridit(num);


    }
    private static void hello() throws IOException{
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

    private static double readd(int row, int cell) throws IOException  {
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


    private static void getKridit(int num)throws IOException{
        System.out.println("На яку суму вам потрібен кредит?");
        Scanner in = new Scanner(System.in);
        Integer sum = in.nextInt();

        sum.toString();

        FileWriter writer = new FileWriter(fn, true);
        writer.write(sum.toString());     //записуємо імя


        System.out.println("На скільки років берете кредит?");
        int year = in.nextInt();

        double CherezGod = sum + year*sum * readd(2,num+1);
        System.out.println("Сума яку потрібно буде віддати" + CherezGod);

        writer.write(CherezGod + "\r\n");
        double vMisyaz = CherezGod / (year*12);
        System.out.println("Сума яку треба сплачувати щомісяця: " + vMisyaz);
        writer.write(vMisyaz + "\r\n");
        writer.flush();
        writer.close();
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
        fn = filename;
    }



    private static void Line(int a){
        for (int i = 1; i<=a; i++){

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