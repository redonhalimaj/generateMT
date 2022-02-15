package com.company;

import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {

        String directory = "src/main/resources/CamtSolution/";
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {

                String incomingXMLFile = directory+file.getName();
                JSONObject parseToJson = parseXMLtoJSON(incomingXMLFile);
                String xmlConverted = parseToJson.toString(4);

                Random rnd = new Random();
                int num = rnd.nextInt(100,999);
                char randomizedCharacter = (char) (rnd.nextInt(26) + 'a');
                String refNumber = String.format("%01d", num);
                String writtenJSON;
                if(file.getName().contains("camt.027")){
                    writtenJSON =  "src/main/resources/WrittenJsonFiles/Nr_"+refNumber+randomizedCharacter+"_BBkOQFBlkCdtTrf_camt.027.json";
                    String writtenJsonFileDestination = writtenJSON;
                    writeJSONFile(xmlConverted,writtenJsonFileDestination);
                }else if(file.getName().contains("camt.087")){
                    writtenJSON =  "src/main/resources/WrittenJsonFiles/Nr_"+refNumber+randomizedCharacter+"_BBkOQFBlkCdtTrf_camt.087.json";
                    String writtenJsonFileDestination = writtenJSON;
                    writeJSONFile(xmlConverted,writtenJsonFileDestination);
                }else if(file.getName().contains("pacs.028")){
                    writtenJSON =  "src/main/resources/WrittenJsonFiles/Nr_"+refNumber+randomizedCharacter+"_BBkOQFBlkCdtTrf_pacs.028.json";
                    String writtenJsonFileDestination = writtenJSON;
                    writeJSONFile(xmlConverted,writtenJsonFileDestination);
                }else if(file.getName().contains("camt.029")){
                    writtenJSON =  "src/main/resources/WrittenJsonFiles/Nr_"+refNumber+randomizedCharacter+"_BBkOQFBlkCdtTrf_camt.029.json";
                    String writtenJsonFileDestination = writtenJSON;
                    writeJSONFile(xmlConverted,writtenJsonFileDestination);
                }else {
                    System.out.println("File is not XML!");
                }

            }
        }

    }


    //Reads the incoming xml file and converts it to string
    public static String readFileAsString(String file) throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public static JSONObject parseXMLtoJSON(String incomingFilePath) throws Exception{
        String xml = readFileAsString(incomingFilePath);
        JSONObject jsonObject = XML.toJSONObject(xml.replaceAll("\\r\\n\\s+|BBkOQF:",""));
        return jsonObject;

    }

    public static void writeJSONFile(String fileToWrite, String fileDestination) throws IOException {
        File writtenFile = new File(fileDestination);
        FileWriter fw = new FileWriter(writtenFile);
        fw.write(fileToWrite.formatted("\n"));
        fw.close();
    }

}
