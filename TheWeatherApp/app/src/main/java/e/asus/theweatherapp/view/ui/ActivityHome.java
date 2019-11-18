package e.asus.theweatherapp.view.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import e.asus.theweatherapp.R;
import e.asus.theweatherapp.SelectTheCity;
import e.asus.theweatherapp.databinding.ActivityMainBinding;
import e.asus.theweatherapp.model.ConsolidatedWeather;
import e.asus.theweatherapp.model.WeatherData;
import e.asus.theweatherapp.view.MainActivity;

public class ActivityHome extends AppCompatActivity {
    ActivityMainBinding binding;
    ActivityHomeViewModel viewModel;
    List<ConsolidatedWeather> dataList;
    HourlyDataAdapter hourlyDataAdapter;
    DailyDataAdapter dailyDataAdapter;
    Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL,
                false);
        binding.recylerHourly.setLayoutManager(layoutManager);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        binding.recylerDaily.setLayoutManager(layoutManager1);

        viewModel = ViewModelProviders.of(ActivityHome.this).get(ActivityHomeViewModel.class);
        dataList = new ArrayList<>();

        viewModel.weatherlivelist.observe(ActivityHome.this, new Observer<WeatherData>() {
            @Override
            public void onChanged(WeatherData weatherData) {
                dataList = weatherData.getConsolidatedWeather();

                double roundOff = Math.round(dataList.get(0).getTheTemp() * 100.0) / 100.0;
                hourlyDataAdapter = new HourlyDataAdapter(ActivityHome.this, dataList);

                dailyDataAdapter = new DailyDataAdapter(ActivityHome.this, dataList);
                binding.textTemp.setText(String.valueOf(roundOff));

                binding.textTempCity.setText(String.valueOf(weatherData.getTitle()));

                double roundoff1 = Math.round(dataList.get(0).getWindSpeed() * 100.0) / 100.0;
                binding.textWindSpeed.setText(String.valueOf(roundoff1));

                double roundoff2 = Math.round(dataList.get(0).getHumidity() * 100.0) / 100.0;
                binding.textHumidity.setText(String.valueOf(roundoff2));

                binding.recylerHourly.setAdapter(hourlyDataAdapter);
                binding.recylerDaily.setAdapter(dailyDataAdapter);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.select_city:

                Intent in = new Intent(ActivityHome.this, SelectTheCity.class);
                startActivity(in);
                break;

        }


        return true;
    }

}
