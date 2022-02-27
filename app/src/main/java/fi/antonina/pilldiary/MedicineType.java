package fi.antonina.pilldiary;

import java.io.Serializable;

public class MedicineType implements Serializable {
    private String medName;
    private String feedBack;
    private String medAmount;
    private String medGetTime;

    public MedicineType(String medName, String feedBack, String medAmount, String medGetTime) {
        this.medName = medName;
        this.feedBack = feedBack;
        this.medAmount = medAmount;
        this.medGetTime = medGetTime;
    }
    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getMedAmount() {
        return medAmount;
    }

    public void setMedAmount(String medAmount) {
        this.medAmount = medAmount;
    }

    public String getMedGetTime() {
        return medGetTime;
    }

    public void setMedGetTime(String medGetTime) {
        this.medGetTime = medGetTime;
    }
}
