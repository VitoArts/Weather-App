package be.ucll.java.mobile.ucllweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import be.ucll.java.mobile.UCLL_Weather.model.citySearch;
import be.ucll.java.mobile.UCLL_Weather.model.weatherSearch;

public class MainActivity extends AppCompatActivity implements Response.Listener, Response.ErrorListener {

    private TextView readText;
    private TextView cityText;
    private TextView countryText;
    private TextView humidityText;
    private TextView pressureText;
    private TextView temperatureText;

    private String latitude;
    private String longitude;

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readText = findViewById(R.id.txtSearch);
        cityText = findViewById(R.id.txtCity);
        countryText = findViewById(R.id.txtCountry);
        humidityText = findViewById(R.id.txtHumidity);
        pressureText = findViewById(R.id.txtPressure);
        temperatureText = findViewById(R.id.txtTemperature);
    }

    public void Search(View view) {
        // Instantiate the RequestQueue for asynchronous operations
        queue = Volley.newRequestQueue(this);

        //Push button = Read name
        String readTxt = readText.getText().toString();
        //Make the url
        String url = UrlMaker(readTxt);

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        // Add the request to the RequestQueue for asynchronous retrieval on separate thread.
        queue.add(req);
    }

    public String UrlMaker(String city){
       city = city.replaceAll(" ","+");
       String geonamesUrl = "http://api.geonames.org/searchJSON?q=" + city + "&maxrows=1&username=jodieorourke";

       //after generation, we log the name in case of problems
       Log.d("url", geonamesUrl);
       return geonamesUrl;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(Object response) {
        // Cast into Gson JSONObject
        JSONObject jsono = (JSONObject) response;

        // Log the output as debug information
        Log.d("TAG", jsono.toString());

        if (jsono.has("geonames")) {
            citySearch cityRespo = new Gson().fromJson(jsono.toString(), citySearch.class);
            if (cityRespo != null && cityRespo.getGeonames() != null && cityRespo.getGeonames().size() > 0) {
                //We generally only need the first input of the list, so we only get the first value.
                //we get and display the city name
                TextView cityOutput = (TextView) cityText;
                cityOutput.setText(cityRespo.getGeonames().get(0).getToponymName());

                //we get and display the country name
                TextView countryOutput = (TextView) countryText;
                countryOutput.setText(cityRespo.getGeonames().get(0).getCountryName());

                //we get the values for the latitude and Longitude.
                latitude = cityRespo.getGeonames().get(0).getLat();
                longitude = cityRespo.getGeonames().get(0).getLng();

                //Using the now given values of Latitude and Longitude we generate our weatherURL
                generateWeather();
            }
        }
        if (jsono.has("weatherObservation")){
            weatherSearch weatherRespo = new Gson().fromJson(jsono.toString(), weatherSearch.class);
            if (weatherRespo != null && weatherRespo.getWeatherObservation() != null) {

                //Set text of found temperature
                TextView temperatureOutput = (TextView) temperatureText;
                temperatureOutput.setText(weatherRespo.getWeatherObservation().getTemperature());

                /*while testing I found that New York always returned null for getHectoPascAltimeter(). Apparently there are some differences in the way countries
                note their weather statistics, Ex. New York indicates pressure with getSeaLevelPressure.
                This is a pain and probably means that there are more exceptions than just pressure, but I haven't found any more.*/
                TextView pressureOutput = (TextView) pressureText;
                String pressure = String.valueOf(weatherRespo.getWeatherObservation().getHectoPascAltimeter());
                if (weatherRespo.getWeatherObservation().getHectoPascAltimeter() == null){
                    pressure = String.valueOf(weatherRespo.getWeatherObservation().getSeaLevelPressure());
                }
                pressureOutput.setText(pressure);

                //Set text of found humidity
                TextView humidityOutput = (TextView) humidityText;
                String humidity = String.valueOf(weatherRespo.getWeatherObservation().getHumidity());
                humidityOutput.setText(humidity);
            }
        }

    }

    private void generateWeather() {
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, WeatherUrl(), null, this, this);
        // Add the request to the RequestQueue for asynchronous retrieval on separate thread.
        queue.add(req);
    }

    public String WeatherUrl(){
        String api_WeatherUrl = "http://api.geonames.org/findNearByWeatherJSON?lat="+latitude+"&lng="+longitude+"&username=jodieorourke";
        //after generation, we log the name in case of problems
        Log.d("url", api_WeatherUrl);
        return api_WeatherUrl;
    }
}