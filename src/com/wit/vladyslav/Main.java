package com.wit.vladyslav;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static String fn;
    public static String GetFN() {
        return fn;
    }
    public static void SetFN(String filename) {
        fn = filename;
    }
    private static ArrayList fileData = new ArrayList();
    public static ArrayList GetFD() {return fileData;}
    public static void SetFD(ArrayList filedata) {fileData = filedata;}

    public static void main(String[] args) throws IOException {

        AllFuncs.helloUser();
        Menu.menu();

    }
}
