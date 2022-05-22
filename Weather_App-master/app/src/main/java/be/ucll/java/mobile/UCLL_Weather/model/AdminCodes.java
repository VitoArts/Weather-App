package be.ucll.java.mobile.UCLL_Weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdminCodes {
    @SerializedName("ISO3166_2")
    @Expose
    private String iSO31662;

    public String getISO31662() {
        return iSO31662;
    }

    public void setISO31662(String iSO31662) {
        this.iSO31662 = iSO31662;
    }
}
