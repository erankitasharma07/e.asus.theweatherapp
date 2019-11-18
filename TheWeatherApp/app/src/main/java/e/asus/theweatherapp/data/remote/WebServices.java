package e.asus.theweatherapp.data.remote;

import e.asus.theweatherapp.model.ConsolidatedWeather;
import e.asus.theweatherapp.model.WeatherData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebServices {

    @GET("api/location/28743736/")
    Call<WeatherData> getWeather();
}
