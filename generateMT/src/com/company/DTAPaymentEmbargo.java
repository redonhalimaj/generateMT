package com.company;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DTAPaymentEmbargo {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\redon\\IdeaProjects\\generateMT\\src\\test\\resources\\mtFiles\\MT103_Embargo_dtazv_Template.txt";
        String dtaFile = readFileAsString(path);
        //System.out.println(mtFile);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("HHmmyyMMdd");
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyMMdd");
        SimpleDateFormat nameConventionForMT1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat nameConventionForMT2 = new SimpleDateFormat("HHmmss");


        Random rnd = new Random();
        int twoDigitNumber = rnd.nextInt(10,99);
        int threeDigitNumber = rnd.nextInt(100,999);
        int totalSum = rnd.nextInt(1,99);
        String finalString = dtaFile
                .replaceAll("<Insert_Date>", formatter1.format(calendar.getTime()))
                .replaceAll("<Insert_Two_Digit_Number>", String.valueOf(twoDigitNumber))
                .replaceAll("<Total_Sum>",String.valueOf(totalSum));

        String newFilePath = "C:\\Users\\redon\\IdeaProjects\\generateMT\\src\\test\\resources\\mtFiles\\generatedPayments\\OutgoingPayments\\Embargowait\\HCOB2BR.DTAZV_SAPDM." + nameConventionForMT1.format(calendar.getTime()) + "." + nameConventionForMT2.format(calendar.getTime()) + "."+threeDigitNumber+".dta";

        File outputFile = new File(newFilePath);
        FileWriter fw = new FileWriter(outputFile);
        fw.write(finalString);
        fw.close();

        String zippedFile = "C:\\Users\\redon\\IdeaProjects\\generateMT\\src\\test\\resources\\mtFiles\\generatedPayments\\OutgoingPayments\\Embargowait\\B2H.PAD.BTEB.AZVJ.EFXP.D" + nameConventionForMT1.format(calendar.getTime()) + ".T" + nameConventionForMT2.format(calendar.getTime()) + ".zip";

        zipFile(newFilePath,zippedFile);

    }
    public static String readFileAsString(String file) throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public static void zipFile(String filePath, String fileDestination) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileDestination);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(filePath);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();
    }

}
