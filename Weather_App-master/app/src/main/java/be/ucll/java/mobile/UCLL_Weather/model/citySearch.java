package be.ucll.java.mobile.UCLL_Weather.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class citySearch {
    @SerializedName("totalResultsCount")
    @Expose
    private Integer totalResultsCount;
    @SerializedName("geonames")
    @Expose
    private List<Geoname> geonames = null;

    public Integer getTotalResultsCount() {
        return totalResultsCount;
    }

    public void setTotalResultsCount(Integer totalResultsCount) {
        this.totalResultsCount = totalResultsCount;
    }

    public List<Geoname> getGeonames() {
        return geonames;
    }

    public void setGeonames(List<Geoname> geonames) {
        this.geonames = geonames;
    }
}
