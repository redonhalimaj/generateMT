package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class MTPayment {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\redon\\IdeaProjects\\generateMT\\src\\test\\resources\\mtFiles\\MT103_Template_Incoming.txt";
        String mtFile = readFileAsString(path);
        //System.out.println(mtFile);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("HHmmyyMMdd");
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyMMdd");
        SimpleDateFormat nameConventionForMT1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat nameConventionForMT2 = new SimpleDateFormat("HHmmss");


        Random rnd = new Random();
        int number = rnd.nextInt(999);
        // this will convert any number sequence into 6 character.
        String ref = String.format("ATCIMBPE%06d", number);



        Scanner sc = new Scanner(System.in);
        System.out.println("Please input amount: ");
        String amount;
        if(sc.hasNext("^[0-9,]+$")) {
            amount = sc.nextLine();
            System.out.println("Your specified amount: " + amount);

            System.out.println("Please input currency: ");
            String currency;

            if(sc.hasNext("[a-zA-Z]{3}")) {
                currency = sc.nextLine();
                System.out.println("Your specified currency: " + currency);

                System.out.println("Please input Recipient BIC:");
                String recipient;

                if(sc.hasNext("[a-zA-Z0-9]{11}")) {
                    recipient = sc.nextLine();
                    System.out.println("Your recipient BIC is: " + recipient.toUpperCase());
                    String regularRecipient = addChar(recipient.toUpperCase(), 'A', 8);
                    System.out.println("Please input Beneficiary BIC:");
                    String beneficiary = sc.nextLine();
                    System.out.println("Your beneficiary BIC is: " + beneficiary.toUpperCase());


                    String hcobClient = selectDebtor();
                    String clientDetails[] = hcobClient.split(",");
                    String debtorIban = clientDetails[0].replaceAll("\\s+","");
                    String name = clientDetails[1];
                    String address = clientDetails[2];
                    String city = clientDetails[3];
                    System.out.println("Name: "+name+" iban: "+debtorIban+" address: "+address+" city: "+city);




                    String finalString = mtFile
                            .replaceAll("<Insert_Time_Date>", formatter.format(calendar.getTime()))
                            .replaceAll("<Insert_Date>", formatter1.format(calendar.getTime()))
                            .replaceAll("<Insert_Ref>", ref)
                            .replaceAll("<Insert_Currency>", currency.toUpperCase())
                            .replaceAll("<Insert_Amount>", amount)
                            .replaceAll("<Receiver_BIC>", regularRecipient)
                            .replaceAll("<Beneficiary_BIC>", beneficiary.toUpperCase())
                            .replaceAll("<Debtor_Iban>",debtorIban)
                            .replaceAll("<Debtor_Name>",name)
                            .replaceAll("<Debtor_Address>",address)
                            .replaceAll("<Debtor_City>",city);


                    String newFilePath = "C:\\Users\\redon\\IdeaProjects\\generateMT\\src\\test\\resources\\mtFiles\\generatedPayments\\IncomingPayments\\MT103_FBE_" + nameConventionForMT1.format(calendar.getTime()) + "." + nameConventionForMT2.format(calendar.getTime()) + ".000.mt";
                    File outputFile = new File(newFilePath);
                    FileWriter fw = new FileWriter(outputFile);


                    fw.write(finalString);
                    fw.close();
                }else{
                    System.out.println("Wrong BIC format, should consist of 11 characters!");
                }
            }else{
                System.out.println("Please input only three letters for Currency Code!");
            }
        }else{
            System.out.println("Your input is a wrong amount format, please use the 'comma' as a separator if using decimal values for your amount!");
        }
    }

    public static String readFileAsString(String file) throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public static String addChar(String str, char ch, int position) {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(position, ch);
        return sb.toString();
    }

    public static String selectDebtor()
    {
        List<String> debtorNames = new ArrayList<>();
        debtorNames.add("DE94 2105 0000 2200 0055 01,Otto Lamprecht,Hafenstraße 18a 24784,Wesaterrönfeld DE");
        debtorNames.add("DE24 2105 0000 2200 0055 00,Herbert Meier,Koenigstraße 4 24768,Rendsburg DE");
        debtorNames.add("DE40 2105 0000 2200 0055 03,Otto Lamprecht,Hafenstraße 18a 24784,Wesaterrönfeld DE");
        debtorNames.add("DE13 2105 0000 2200 0055 04,Otto Lamprecht,Hafenstraße 18a 24784,Wesaterrönfeld DE");
        debtorNames.add("DE83 2105 0000 2200 0055 05,Otto Lamprecht,Hafenstraße 18a 24784,Wesaterrönfeld DE");
        debtorNames.add("DE92 2105 0000 0030 0000 10,Hamburg Commercial Bank,Martensdamm 4 24103,Kiel DE");
        debtorNames.add("DE67 2105 0000 0051 5008 01,Hamburg Commercial Bank,Martensdamm 4 24103,Kiel DE");
        debtorNames.add("DE40 2105 0000 0051 5008 02,Hamburg Commercial Bank,Martensdamm 4 24103,Kiel DE");
        debtorNames.add("DE94 2105 0000 1100 3312 45,Susan Smith,Toyon Rd 5404 92115,San Diego CA");
        debtorNames.add("DE12 2105 0000 0796 6070 00,Frank Niemand,Klinter Weg 98a 24768,Rendsburg DE");
        int upperBound = 10;
        Random rand = new Random();
        int randomClient = rand.nextInt(upperBound);
        return debtorNames.get(randomClient);
    }
}
