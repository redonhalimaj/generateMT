package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MTPayment {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\redon\\IdeaProjects\\generateMT\\src\\test\\resources\\mtFiles\\MT103.txt";
        String mtFile = readFileAsString(path);
        System.out.println(mtFile);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("HHmmyyMMdd");
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyMMdd");

        String finalString = mtFile
                .replaceAll("<Insert_Time_Date>",formatter.format(calendar.getTime()))
                .replaceAll("<Insert_Date>",formatter1.format(calendar.getTime()));

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
