package com.tw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private static Display dp = new Display();
    private static Process process = new Process();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Info> infoList = new ArrayList<>();
        dp.displayhome();
        String str = "";
        do {
            str = sc.nextLine();
            switch (str) {
                case "1":
                    process.oneProcess(sc,infoList);
                    break;
                case "2":
                    process.twoProcess(sc,infoList);
                    break;
                case "3":
                    break;
            }
            if (str.equals("3")) break;
        }while (true);
    }


}
