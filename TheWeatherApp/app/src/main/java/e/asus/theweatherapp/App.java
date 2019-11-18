package e.asus.theweatherapp;

import android.app.Application;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import e.asus.theweatherapp.data.WeatherRepo;
import e.asus.theweatherapp.data.local.WeatherDao;
import e.asus.theweatherapp.data.local.WeatherDatabase;
import e.asus.theweatherapp.data.remote.RetrofitCLient;
import e.asus.theweatherapp.data.remote.WebServices;

public class App extends Application {

    WeatherDatabase weatherDatabase;
    WeatherDao weatherDao;
    Executor executor;
    public static WeatherRepo weatherRepo;

    @Override
    public void onCreate() {
        super.onCreate();

        weatherDatabase = WeatherDatabase.getInstance(this);
        weatherDao = WeatherDatabase.getInstance(this).weatherDao();
        executor = Executors.newSingleThreadExecutor();
        weatherRepo = new WeatherRepo(weatherDao, RetrofitCLient.getClient().create(WebServices.class),
                executor);
    }
}
