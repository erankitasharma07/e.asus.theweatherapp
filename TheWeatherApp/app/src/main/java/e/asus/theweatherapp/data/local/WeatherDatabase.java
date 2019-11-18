package e.asus.theweatherapp.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import e.asus.theweatherapp.model.ConsolidatedWeather;

@Database(entities = ConsolidatedWeather.class, version = 1, exportSchema = false)
public abstract class WeatherDatabase extends RoomDatabase {
    public abstract WeatherDao weatherDao();
    private static WeatherDatabase weatherDatabase;
    private static String lock = "test";

    public static WeatherDatabase getInstance(Context context) {

            if (weatherDatabase == null) {

                weatherDatabase = Room.databaseBuilder(
                        context.getApplicationContext(),
                        WeatherDatabase.class,
                        "weather.db"
                ).fallbackToDestructiveMigration().build();

            }


        return weatherDatabase;

    }


}
