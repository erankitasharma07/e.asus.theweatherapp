package e.asus.theweatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import e.asus.theweatherapp.view.ui.AdapterOfCity;
import e.asus.theweatherapp.view.ui.ListOfCity;

public class SelectTheCity extends AppCompatActivity {
    private List<ListOfCity> cityList = new ArrayList<>();
    RecyclerView recyclerView;
    AdapterOfCity adapterOfCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_the_city);

        recyclerView = findViewById(R.id.cities_recycler);

        adapterOfCity = new AdapterOfCity(cityList);
        RecyclerView.LayoutManager mLayoutManager = new
                LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(adapterOfCity);

        prepareCitiesList();
    }

    private void prepareCitiesList() {
        ListOfCity listOfCity = new ListOfCity("Delhi");
        cityList.add(listOfCity);
        listOfCity = new ListOfCity("Mumbai");
        cityList.add(listOfCity);

        adapterOfCity.notifyDataSetChanged();

    }
}
