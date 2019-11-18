package e.asus.theweatherapp.view.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import e.asus.theweatherapp.App;
import e.asus.theweatherapp.data.WeatherRepo;
import e.asus.theweatherapp.model.WeatherData;

public class ActivityHomeViewModel extends ViewModel {

    public LiveData<WeatherData> weatherlivelist = App.weatherRepo.getConsolidateWeather();


}
