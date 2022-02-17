package com.company;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Camt87 {

    private String SndgInst;
    private String RcvgInst;
    private String FileRef;
    private String SrvcId;
    private String FileBusDt;
    private String FileCycleNo;
    private String IntrBkSttlmDt;
    private String CreDtTm;
    private String Assignee;
    private String Assigner;
    private String AssgnmtId;

    private String InstrInf;
    private String InstrCd;

    private String OrgnlTxId;

    private String CdtrNm;
    private String CdtrAgt;
    private String PmtTpInf;
    private String DbtrAcct;
    private String SttlmMtd;
    private String ClrSys;
    private String CdtrAcct;
    private String DbtrAgt;
    private String DbtrNm;

    private String OrgnlIntrBkSttlmAmtl;
    private String OrgnlIntrBkSttlmCcy;

    private String OrgnlMsgId;
    private String OrgnlMsgNmId;

    private String OrgnlEndToEndId;
    private String OrgnlIntrBkSttlmDt;


    private String CaseId;
    private String CaseCretr;

    public String getSndgInst(JSONObject jsonObject) {
        return SndgInst=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").get("SndgInst").toString();
    }
    public String getRcvgInst(JSONObject jsonObject) {
        return RcvgInst=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").get("RcvgInst").toString();
    }
    public String getFileRef(JSONObject jsonObject) {
        return FileRef=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").get("FileRef").toString();
    }
    public String getSrvcId(JSONObject jsonObject) {
        return SrvcId=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").get("SrvcId").toString();
    }
    public String getFileBusDt(JSONObject jsonObject) {
        return FileBusDt=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").get("FileBusDt").toString();
    }
    public String getFileCycleNo(JSONObject jsonObject) {
        return FileCycleNo=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").get("FileCycleNo").toString();
    }
    public String getIntrBkSttlmDt(JSONObject jsonObject) {
        return IntrBkSttlmDt=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt")
                .getJSONObject("Mod").get("IntrBkSttlmDt").toString();
    }
    public String getCreDtTm(JSONObject jsonObject) {
        return CreDtTm=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt")
                .getJSONObject("Assgnmt").get("CreDtTm").toString();
    }
    public String getAssignee(JSONObject jsonObject) {
        return Assignee=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Assgnmt")
                .getJSONObject("Assgne").getJSONObject("Agt").getJSONObject("FinInstnId").get("BICFI").toString();
    }
    public String getAssigner(JSONObject jsonObject) {
        return Assigner=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Assgnmt")
                .getJSONObject("Assgnr").getJSONObject("Agt").getJSONObject("FinInstnId").get("BICFI").toString();
    }
    public String getAssgnmtId(JSONObject jsonObject) {
        return AssgnmtId=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt")
                .getJSONObject("Assgnmt").get("Id").toString();
    }
    public String getInstrInf(JSONObject jsonObject) {
        return InstrInf=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt")
                .getJSONObject("InstrForAssgne").get("InstrInf").toString();
    }
    public String getInstrCd(JSONObject jsonObject) {
        return InstrCd=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt")
                .getJSONObject("InstrForAssgne").get("Cd").toString();
    }
    public String getOrgnlTxId(JSONObject jsonObject) {
        return OrgnlTxId = jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").get("OrgnlTxId").toString();
    }
    public String getCdtrNm(JSONObject jsonObject) {
        return CdtrNm= jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").getJSONObject("OrgnlTxRef").getJSONObject("Cdtr")
                .getJSONObject("Pty").get("Nm").toString();
    }
    public String getCdtrAgt(JSONObject jsonObject) {
        return CdtrAgt= jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").getJSONObject("OrgnlTxRef").getJSONObject("CdtrAgt")
                .getJSONObject("FinInstnId").get("BICFI").toString();
    }
    public String getPmtTpInf(JSONObject jsonObject) {
        return PmtTpInf=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").getJSONObject("OrgnlTxRef").getJSONObject("PmtTpInf")
                .getJSONObject("SvcLvl").get("Cd").toString();
    }
    public String getDbtrAcct(JSONObject jsonObject) {
        return DbtrAcct= jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").getJSONObject("OrgnlTxRef").getJSONObject("DbtrAcct")
                .getJSONObject("Id").get("IBAN").toString();
    }
    public String getSttlmMtd(JSONObject jsonObject) {
        return SttlmMtd=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").getJSONObject("OrgnlTxRef").getJSONObject("SttlmInf").get("SttlmMtd").toString();
    }
    public String getClrSys(JSONObject jsonObject) {
        return ClrSys=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").getJSONObject("OrgnlTxRef").getJSONObject("SttlmInf")
                .getJSONObject("ClrSys").get("Prtry").toString();
    }
    public String getCdtrAcct(JSONObject jsonObject) {
        return CdtrAcct=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").getJSONObject("OrgnlTxRef").getJSONObject("CdtrAcct")
                .getJSONObject("Id").get("IBAN").toString();
    }
    public String getDbtrAgt(JSONObject jsonObject) {
        return DbtrAgt=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").getJSONObject("OrgnlTxRef").getJSONObject("DbtrAgt")
                .getJSONObject("FinInstnId").get("BICFI").toString();
    }
    public String getDbtrNm(JSONObject jsonObject) {
        return DbtrNm=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").getJSONObject("OrgnlTxRef").getJSONObject("Dbtr").getJSONObject("Pty").get("Nm").toString();
    }
    public String getOrgnlIntrBkSttlmAmtl(JSONObject jsonObject) {
        return OrgnlIntrBkSttlmAmtl=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").getJSONObject("OrgnlIntrBkSttlmAmt").get("content").toString();
    }
    public String getOrgnlIntrBkSttlmCcy(JSONObject jsonObject) {
        return OrgnlIntrBkSttlmCcy=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").getJSONObject("OrgnlIntrBkSttlmAmt").get("Ccy").toString();
    }
    public String getOrgnlMsgId(JSONObject jsonObject) {
        return OrgnlMsgId= jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").getJSONObject("OrgnlGrpInf").get("OrgnlMsgId").toString();
    }
    public String getOrgnlMsgNmId(JSONObject jsonObject) {
        return OrgnlMsgNmId= jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").getJSONObject("OrgnlGrpInf").get("OrgnlMsgNmId").toString();
    }
    public String getOrgnlEndToEndId(JSONObject jsonObject) {
        return OrgnlEndToEndId= jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").get("OrgnlEndToEndId").toString();
    }
    public String getOrgnlIntrBkSttlmDt(JSONObject jsonObject) {
        return OrgnlIntrBkSttlmDt= jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Undrlyg")
                .getJSONObject("IntrBk").get("OrgnlIntrBkSttlmDt").toString();
    }
    public String getCaseId(JSONObject jsonObject) {
        return CaseId=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Case").get("Id").toString();
    }
    public String getCaseCretr(JSONObject jsonObject) {
        return CaseCretr=jsonObject.getJSONObject("BBkOQFBlkCdtTrf").getJSONObject("ReqToModfyPmt").getJSONObject("Case").getJSONObject("Cretr")
                .getJSONObject("Agt").getJSONObject("FinInstnId").get("BICFI").toString();
    }

    public static void writeCamt87File(String SndgInst,String RcvgInst, String FileRef,String SrvcId,String FileBusDt,
                                      String FileCycleNo,String IntrBkSttlmDt,String Assignee, String Assigner,String InstrInf,
                                      String CreDtTm,String AssgnmtId,String InstrCd,String OrgnlTxId,String CdtrNm,
                                      String CdtrAgt,String PmtTpInf, String DbtrAcct,String SttlmMtd,String ClrSys,
                                      String CdtrAcct, String DbtrAgt,String DbtrNm,String OrgnlIntrBkSttlmAmtl,
                                      String OrgnlIntrBkSttlmCcy,String OrgnlMsgId,String OrgnlMsgNmId,String OrgnlEndToEndId,
                                      String OrgnlIntrBkSttlmDt,String CaseId,String CaseCretr,String fileDestination) throws IOException {

        File writtenFile = new File(fileDestination);
        FileWriter fw = new FileWriter(writtenFile);
        fw.write("Sending Institution: "+SndgInst+"\n");
        fw.write("Receiving Institution: "+RcvgInst+"\n");
        fw.write("File Reference: "+FileRef+"\n");
        fw.write("Service ID: "+SrvcId+"\n");
        fw.write("File Bus Date: "+FileBusDt+"\n");
        fw.write("File Cycle Number: "+FileCycleNo+"\n");
        fw.write("Interbank Settlement Date: "+IntrBkSttlmDt+"\n");
        fw.write("Creation Date Time: "+CreDtTm+"\n");
        fw.write("Assignee: "+Assignee+"\n");
        fw.write("Assigner: "+Assigner+"\n");
        fw.write("Instruction Info: "+InstrInf+"\n");
        fw.write("Assignment ID: "+AssgnmtId+"\n");
        fw.write("Assignment Instruction CD: "+InstrCd+"\n");
        fw.write("Original Transaction ID: "+OrgnlTxId+"\n");
        fw.write("Creditor Name: "+CdtrNm+"\n");
        fw.write("Creditor Agent BIC: "+CdtrAgt+"\n");
        fw.write("Creditor Account: "+CdtrAcct+"\n");
        fw.write("Payment to payment Info: "+PmtTpInf+"\n");
        fw.write("Debtor Name: "+DbtrNm+"\n");
        fw.write("Debtor Agent BIC: "+DbtrAgt+"\n");
        fw.write("Debtor Account: "+DbtrAcct+"\n");
        fw.write("Original Instruction Settlement Amount: "+OrgnlIntrBkSttlmAmtl+"\n");
        fw.write("Original Instruction Settlement Currency: "+OrgnlIntrBkSttlmCcy+"\n");
        fw.write("Settlement Method: "+SttlmMtd+"\n");
        fw.write("Clearing System: "+ClrSys+"\n");
        fw.write("Original Message ID: "+OrgnlMsgId+"\n");
        fw.write("Original Message Name ID: "+OrgnlMsgNmId+"\n");
        fw.write("Original End-to-end ID: "+OrgnlEndToEndId+"\n");
        fw.write("Original Interbank Settlement Date: "+OrgnlIntrBkSttlmDt+"\n");
        fw.write("Case ID: "+CaseId+"\n");
        fw.write("Case Creator : "+CaseCretr+"\n");
        fw.close();
    }

}
