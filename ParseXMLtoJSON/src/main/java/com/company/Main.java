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

                String writtenJSON;
                if(file.getName().contains("camt.027")){
                    writtenJSON =  "src/main/resources/WrittenJsonFiles/Nr_"+file.getName().replaceAll(".xml",".json");
                    String writtenJsonFileDestination = writtenJSON;
                    writeJSONFile(xmlConverted,writtenJsonFileDestination);

                    Camt27 claimOfNonReceipt = new Camt27();
                    String output = "src/main/resources/OutputFiles/Nr_"+file.getName().replaceAll(".xml",".txt");
                    claimOfNonReceipt.writeCamt27File(claimOfNonReceipt.getSndgInst(parseToJson), claimOfNonReceipt.getRcvgInst(parseToJson), claimOfNonReceipt.getFileRef(parseToJson),
                            claimOfNonReceipt.getSrvcId(parseToJson),claimOfNonReceipt.getAssignee(parseToJson),claimOfNonReceipt.getAssigner(parseToJson),claimOfNonReceipt.getInstrInf(parseToJson),
                            claimOfNonReceipt.getOrgnlTxId(parseToJson),claimOfNonReceipt.getCdtrNm(parseToJson),claimOfNonReceipt.getCdtrAgt(parseToJson),claimOfNonReceipt.getPmtTpInf(parseToJson),
                            claimOfNonReceipt.getDbtrAcct(parseToJson),claimOfNonReceipt.getSttlmMtd(parseToJson),claimOfNonReceipt.getClrSys(parseToJson),claimOfNonReceipt.getCdtrAcct(parseToJson),
                            claimOfNonReceipt.getDbtrAgt(parseToJson),claimOfNonReceipt.getDbtrNm(parseToJson),claimOfNonReceipt.getOrgnlMsgId(parseToJson),claimOfNonReceipt.getOrgnlMsgNmId(parseToJson),
                            claimOfNonReceipt.getOrgnlEndToEndId(parseToJson),claimOfNonReceipt.getOrgnlIntrBkSttlmDt(parseToJson),claimOfNonReceipt.getCaseId(parseToJson),claimOfNonReceipt.getCaseCretr(parseToJson),
                            output);


                }else if(file.getName().contains("camt.087")){

                    writtenJSON =  "src/main/resources/WrittenJsonFiles/Nr_"+file.getName().replaceAll(".xml",".json");
                    String writtenJsonFileDestination = writtenJSON;
                    writeJSONFile(xmlConverted,writtenJsonFileDestination);

                    Camt87 reqDateModification = new Camt87();
                    String output = "src/main/resources/OutputFiles/Nr_"+file.getName().replaceAll(".xml",".txt");
                    reqDateModification.writeCamt87File(reqDateModification.getSndgInst(parseToJson),reqDateModification.getRcvgInst(parseToJson),reqDateModification.getFileRef(parseToJson),
                            reqDateModification.getSrvcId(parseToJson),reqDateModification.getFileBusDt(parseToJson),reqDateModification.getFileCycleNo(parseToJson),
                            reqDateModification.getIntrBkSttlmDt(parseToJson),reqDateModification.getAssignee(parseToJson),reqDateModification.getAssigner(parseToJson),
                            reqDateModification.getInstrInf(parseToJson), reqDateModification.getCreDtTm(parseToJson),reqDateModification.getAssgnmtId(parseToJson),
                            reqDateModification.getInstrCd(parseToJson), reqDateModification.getOrgnlTxId(parseToJson), reqDateModification.getCdtrNm(parseToJson), reqDateModification.getCdtrAgt(parseToJson),
                            reqDateModification.getPmtTpInf(parseToJson), reqDateModification.getDbtrAcct(parseToJson), reqDateModification.getSttlmMtd(parseToJson),
                            reqDateModification.getClrSys(parseToJson), reqDateModification.getCdtrAcct(parseToJson), reqDateModification.getDbtrAgt(parseToJson), reqDateModification.getDbtrNm(parseToJson),
                            reqDateModification.getOrgnlIntrBkSttlmAmtl(parseToJson), reqDateModification.getOrgnlIntrBkSttlmCcy(parseToJson), reqDateModification.getOrgnlMsgId(parseToJson),
                            reqDateModification.getOrgnlMsgNmId(parseToJson), reqDateModification.getOrgnlEndToEndId(parseToJson), reqDateModification.getOrgnlIntrBkSttlmDt(parseToJson), reqDateModification.getCaseId(parseToJson),
                            reqDateModification.getCaseCretr(parseToJson),output);

                }else if(file.getName().contains("pacs.028")){

                    writtenJSON =  "src/main/resources/WrittenJsonFiles/Nr_"+file.getName().replaceAll(".xml",".json");
                    String writtenJsonFileDestination = writtenJSON;
                    writeJSONFile(xmlConverted,writtenJsonFileDestination);

                }else if(file.getName().contains("camt.029")){

                    writtenJSON =  "src/main/resources/WrittenJsonFiles/Nr_"+file.getName().replaceAll(".xml",".json");;
                    String writtenJsonFileDestination = writtenJSON;
                    writeJSONFile(xmlConverted,writtenJsonFileDestination);

                }else {

                    System.out.println("File is not XML!");

                }

            }
        }

    }


    //Reads the incoming xml file and converts it to string
    public static String readFileAsString(String file) throws Exception {

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
