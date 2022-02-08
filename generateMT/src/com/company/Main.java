package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {

        Random rnd = new Random();
        int number = rnd.nextInt(999);

        // this will convert any number sequence into 6 character.
        System.out.println(String.format("ATCMT%06d", number));
        // write your code here
//        String path = "C:\\Users\\redon\\IdeaProjects\\generateMT\\src\\test\\resources\\mtFiles\\MT103.txt";
//        ;
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat formatter = new SimpleDateFormat("HHmmyyMMdd");
//        SimpleDateFormat formatter1 = new SimpleDateFormat("yyMMdd");
//        System.out.println(formatter.format(calendar.getTime()));
//        BufferedReader br = null;
//        try {
//            File file = new File(path); // java.io.File
//            Path pathFile = Paths.get(path);
//            long count = Files.lines(pathFile).count();
//            //System.out.println(count);
//            FileReader fr = new FileReader(file); // java.io.FileReader
//            br = new BufferedReader(fr); // java.io.BufferedReader
//            String newFilePath = "C:\\Users\\redon\\IdeaProjects\\generateMT\\src\\test\\resources\\mtFiles\\MT103.mt";
//            File outputFile = new File(newFilePath);
//            FileWriter fw = new FileWriter(outputFile);
//            BufferedWriter bw = new BufferedWriter(fw);
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//                bw.write(line.replaceAll("<Insert_Time_Date>|<Insert_Date>", formatter.format(calendar.getTime())));
//            }
//
//            bw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (br != null) br.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
