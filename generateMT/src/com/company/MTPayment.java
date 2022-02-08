package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class MTPayment {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\redon\\IdeaProjects\\generateMT\\src\\test\\resources\\mtFiles\\MT103_Template_Incoming.txt";
        String mtFile = readFileAsString(path);
        //System.out.println(mtFile);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("HHmmyyMMdd");
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyMMdd");


        Random rnd = new Random();
        int number = rnd.nextInt(999);
        // this will convert any number sequence into 6 character.
        String ref = String.format("ATCIMBPE%06d", number);


        Scanner sc = new Scanner(System.in);
        System.out.println("Please input amount: ");
        String amount = sc.next();
        System.out.println("Your specified amount: "+amount);

        System.out.println("Please input currency: ");
        String currency = sc.next();
        System.out.println("Your specified currency: "+currency);



        String finalString = mtFile
                .replaceAll("<Insert_Time_Date>",formatter.format(calendar.getTime()))
                .replaceAll("<Insert_Date>",formatter1.format(calendar.getTime()))
                .replaceAll("<Insert_Ref>",ref)
                .replaceAll("<Insert_Currency>",currency)
                .replaceAll("<Insert_Amount>",amount);



        String newFilePath = "C:\\Users\\redon\\IdeaProjects\\generateMT\\src\\test\\resources\\mtFiles\\MT103.mt";
        File outputFile = new File(newFilePath);
        FileWriter fw = new FileWriter(outputFile);


        fw.write(finalString);
        fw.close();

    }

    public static String readFileAsString(String file) throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
