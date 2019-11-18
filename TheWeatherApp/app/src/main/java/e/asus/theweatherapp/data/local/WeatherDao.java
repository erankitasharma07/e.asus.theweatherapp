package e.asus.theweatherapp.data.local;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

import e.asus.theweatherapp.model.ConsolidatedWeather;

@Dao
public interface WeatherDao {

    @Insert
     void saveWeather(List<ConsolidatedWeather> consolidatedWeatherList);





}
