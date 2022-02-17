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
        return CdtrAgt;
    }
    public String getPmtTpInf(JSONObject jsonObject) {
        return PmtTpInf;
    }
    public String getDbtrAcct(JSONObject jsonObject) {
        return DbtrAcct;
    }
    public String getSttlmMtd(JSONObject jsonObject) {
        return SttlmMtd;
    }
    public String getClrSys(JSONObject jsonObject) {
        return ClrSys;
    }
    public String getCdtrAcct(JSONObject jsonObject) {
        return CdtrAcct;
    }
    public String getDbtrAgt(JSONObject jsonObject) {
        return DbtrAgt;
    }
    public String getDbtrNm(JSONObject jsonObject) {
        return DbtrNm;
    }
    public String getOrgnlIntrBkSttlmAmtl(JSONObject jsonObject) {
        return OrgnlIntrBkSttlmAmtl;
    }
    public String getOrgnlIntrBkSttlmCcy(JSONObject jsonObject) {
        return OrgnlIntrBkSttlmCcy;
    }
    public String getOrgnlMsgId(JSONObject jsonObject) {
        return OrgnlMsgId;
    }
    public String getOrgnlMsgNmId(JSONObject jsonObject) {
        return OrgnlMsgNmId;
    }
    public String getOrgnlEndToEndId(JSONObject jsonObject) {
        return OrgnlEndToEndId;
    }
    public String getOrgnlIntrBkSttlmDt(JSONObject jsonObject) {
        return OrgnlIntrBkSttlmDt;
    }
    public String getCaseId(JSONObject jsonObject) {
        return CaseId;
    }
    public String getCaseCretr(JSONObject jsonObject) {
        return CaseCretr;
    }

}
