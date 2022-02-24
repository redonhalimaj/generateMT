package com.company;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class MTReturn {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\redon\\IdeaProjects\\generateMT\\src\\test\\resources\\mtFiles\\return_template.txt";
        String mtFile = readFileAsString(path);


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyMMdd");
        SimpleDateFormat nameConventionForMT1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat nameConventionForMT2 = new SimpleDateFormat("HHmmss");


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

                System.out.println("Please input Creditor Name:");
                String creditorName;
                if(sc.hasNext("[a-zA-Z ]+")){
                    creditorName = sc.nextLine();
                    System.out.println("The creditor name to return the money to is: "+ creditorName);

                    System.out.println("Please input Creditor Iban:");
                    String creditorIban;
                    if(sc.hasNext("[a-zA-Z0-9]{22}")) {
                        creditorIban = sc.nextLine();
                        System.out.println("The creditor iban to return the money to is: " + creditorIban);

                        System.out.println("Please input Creditor Address:");
                        String creditorAddress;
                        if (sc.hasNext("[a-zA-Z0-9]+")) {
                            creditorAddress = sc.nextLine();
                            System.out.println("Creditor Address is: " + creditorAddress);

                            System.out.println("Please input Debtor BIC: ");
                            String debtorBic;
                            if(sc.hasNext("[a-zA-Z0-9]{11}")) {
                                debtorBic = sc.nextLine();
                                System.out.println("Debtor BIC of the return payment is: " + debtorBic.toUpperCase());

                                System.out.println("Please input Sending BIC:");
                                String sender;
                                if (sc.hasNext("[a-zA-Z0-9]{11}")) {
                                    sender = sc.nextLine();
                                    System.out.println("Senging BIC is: " + sender.toUpperCase());
                                    String regularRecipient = addChar(sender.toUpperCase(), 'A', 8);

                                    System.out.println("Please input Debtor Account: ");
                                    String debtorAccount;
                                    if(sc.hasNext("[a-zA-Z0-9]+")) {
                                        debtorAccount = sc.nextLine();
                                        System.out.println("Debtor Account is: " + debtorAccount);

                                        System.out.println("Please input Debtor Name:");
                                        String debtorName;
                                        if(sc.hasNext("[a-zA-Z0-9]+")) {
                                            debtorName = sc.nextLine();
                                            System.out.println("Debtor Name is: " + debtorName);

                                            System.out.println("Please input Debtor Address: ");
                                            String debtorAddress;
                                            if (sc.hasNext("[a-zA-Z0-9,]+")) {
                                                debtorAddress = sc.nextLine();
                                                System.out.println("Debtor address is: " + debtorAddress);

                                                System.out.println("Please input Original Payment reference: ");
                                                String ref;
                                                if (sc.hasNext("[a-zA-Z0-9]+")) {
                                                    ref = sc.nextLine();
                                                    System.out.println("The original payment reference is " + ref);

                                                    String finalString = mtFile
                                                            .replaceAll("<Insert_Date>", formatter1.format(calendar.getTime()))
                                                            .replaceAll("<Insert_Time>", nameConventionForMT2.format(calendar.getTime()))
                                                            .replaceAll("<Insert_Ref>", ref)
                                                            .replaceAll("<Currency>", currency.toUpperCase())
                                                            .replaceAll("<Amount>", amount)
                                                            .replaceAll("<Creditor_Name>", creditorName)
                                                            .replaceAll("<Creditor_Iban>", creditorIban.replaceAll(" ", ""))
                                                            .replaceAll("<Creditor_Address>",creditorAddress)
                                                            .replaceAll("<Sender_Bic>", regularRecipient)
                                                            .replaceAll("<Debtor_Bic>", debtorBic.toUpperCase())
                                                            .replaceAll("<Debtor_Account>", debtorAccount)
                                                            .replaceAll("<Debtor_Name>",debtorName)
                                                            .replaceAll("<Debtor_Address>",debtorAddress);


                                                    String newFilePath = "C:\\Users\\redon\\IdeaProjects\\generateMT\\src\\test\\resources\\mtFiles\\generatedPayments\\IncomingPayments\\Return\\MT103_FBE_" + nameConventionForMT1.format(calendar.getTime()) + "." + nameConventionForMT2.format(calendar.getTime()) + ".000.mt";
                                                    File outputFile = new File(newFilePath);
                                                    FileWriter fw = new FileWriter(outputFile);


                                                    fw.write(finalString);
                                                    fw.close();
                                                } else {
                                                    System.out.println("Please don't type letters in the TPH Reference!");
                                                }
                                            }else{
                                                System.out.println("Wrong address format!");
                                            }
                                        }else{
                                            System.out.println("Wrong Debtor Name Format!");
                                        }
                                    }else{
                                        System.out.println("Wrong Account Format!");
                                    }
                                } else {
                                    System.out.println("Wrong BIC format, should consist of 11 characters!");
                                }
                            }else {
                                System.out.println("Wrong BIC format of debtor, should consist of 11 characters!");
                            }
                        }else
                        {
                            System.out.println("Wrong Creditor Address Format!");
                        }
                    }
                    else {
                        System.out.println("Please input just a 12 digit IBAN!");
                    }
                }
                else{
                    System.out.println("Wrong Debtor Name.");
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

}
