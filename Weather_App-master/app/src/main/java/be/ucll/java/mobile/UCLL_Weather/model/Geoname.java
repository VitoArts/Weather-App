package be.ucll.java.mobile.UCLL_Weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geoname {
    @SerializedName("adminCode")
    @Expose
    private String adminCode;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("geonameId")
    @Expose
    private Integer geonameId;
    @SerializedName("toponymName")
    @Expose
    private String toponymName;
    @SerializedName("countryId")
    @Expose
    private String countryId;
    @SerializedName("fcl")
    @Expose
    private String fcl;
    @SerializedName("population")
    @Expose
    private Integer population;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("fclName")
    @Expose
    private String fclName;
    @SerializedName("adminCodes")
    @Expose
    private AdminCodes adminCodes;
    @SerializedName("countryName")
    @Expose
    private String countryName;
    @SerializedName("fcodeName")
    @Expose
    private String fcodeName;
    @SerializedName("adminName")
    @Expose
    private String adminName;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("fcode")
    @Expose
    private String fcode;

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Integer getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(Integer geonameId) {
        this.geonameId = geonameId;
    }

    public String getToponymName() {
        return toponymName;
    }

    public void setToponymName(String toponymName) {
        this.toponymName = toponymName;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getFcl() {
        return fcl;
    }

    public void setFcl(String fcl) {
        this.fcl = fcl;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFclName() {
        return fclName;
    }

    public void setFclName(String fclName) {
        this.fclName = fclName;
    }

    public AdminCodes getAdminCodes1() {
        return adminCodes;
    }

    public void setAdminCodes(AdminCodes adminCodes) {
        this.adminCodes = adminCodes;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFcodeName() {
        return fcodeName;
    }

    public void setFcodeName(String fcodeName) {
        this.fcodeName = fcodeName;
    }

    public String getAdminName1() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }
}
