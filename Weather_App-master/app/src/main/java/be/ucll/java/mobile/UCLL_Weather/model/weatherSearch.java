package be.ucll.java.mobile.UCLL_Weather.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class weatherSearch {
    @SerializedName("weatherObservation")
    @Expose
    private WeatherObservation weatherObservation;

    public WeatherObservation getWeatherObservation() {
        return weatherObservation;
    }

    public void setWeatherObservation(WeatherObservation weatherObservation) {
        this.weatherObservation = weatherObservation;
    }
}
