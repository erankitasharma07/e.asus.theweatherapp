package e.asus.theweatherapp.data;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.Executor;

import e.asus.theweatherapp.data.local.WeatherDao;
import e.asus.theweatherapp.data.remote.WebServices;
import e.asus.theweatherapp.model.ConsolidatedWeather;
import e.asus.theweatherapp.model.WeatherData;
import e.asus.theweatherapp.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepo {

    public WeatherDao weatherDao;
    public WebServices webServices;
    public Executor executor;
    public MutableLiveData<WeatherData> consolidateWeatherlist;

    public WeatherRepo(WeatherDao weatherDao, WebServices webServices, Executor executor) {
        this.weatherDao = weatherDao;
        this.webServices = webServices;
        this.executor = executor;


    }

    public LiveData<WeatherData> getConsolidateWeather() {
        consolidateWeatherlist = new MutableLiveData<>();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                webServices.getWeather().enqueue(new Callback<WeatherData>() {
                    @Override
                    public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                        Log.d("data", response.message());
                        if (response.body() != null) {
                            WeatherData consolidatedWeathers = response.body();
                            consolidateWeatherlist.postValue(consolidatedWeathers);
                        }

                    }

                    @Override
                    public void onFailure(Call<WeatherData> call, Throwable t) {
                        Log.e("failed", t.getMessage());
                    }
                });
            }
        });

        return consolidateWeatherlist;
    }
}
