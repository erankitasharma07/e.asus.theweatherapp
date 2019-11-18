package e.asus.theweatherapp.view.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import e.asus.theweatherapp.R;
import e.asus.theweatherapp.databinding.HourlyItemBinding;
import e.asus.theweatherapp.model.ConsolidatedWeather;
import it.sephiroth.android.library.picasso.Picasso;

public class HourlyDataAdapter extends RecyclerView.Adapter<HourlyDataAdapter.MyViewHolder> {
    int position;
    HourlyItemBinding hourlyItemBinding;
    List<ConsolidatedWeather> consolidatedWeatherList;
    Context context;

    public HourlyDataAdapter(Context context, List<ConsolidatedWeather> consolidatedWeatherList) {

        this.context = context;
        this.consolidatedWeatherList = consolidatedWeatherList;
    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        hourlyItemBinding = DataBindingUtil.inflate(inflater, R.layout.hourly_item, parent, false);
        return new MyViewHolder(hourlyItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(consolidatedWeatherList.get(position));


    }

    @Override
    public int getItemCount() {
        return consolidatedWeatherList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(ConsolidatedWeather consolidatedWeather) {
            double roundOff = Math.round(consolidatedWeather.getTheTemp() * 100.0) / 100.0;
            hourlyItemBinding.textWeatherTemp.setText(String.valueOf(roundOff));

            if (consolidatedWeather.getWeatherStateName().equals("Showers")) {
                hourlyItemBinding.imageWeatherIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.showers));
            }
            if (consolidatedWeather.getWeatherStateName().equals("Heavy Cloud")){
                hourlyItemBinding.imageWeatherIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.heavy_cloud));
            }
            if (consolidatedWeather.getWeatherStateName().equals("Heavy Rain")){
                hourlyItemBinding.imageWeatherIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.heavy_rain));
            }
            if (consolidatedWeather.getWeatherStateName().equals("Light Cloud")){
                hourlyItemBinding.imageWeatherIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.light_clouds));
            }
            //  hourlyItemBinding.textWeatherTime.setText(String.valueOf(consolidatedWeather.getCreated()));
            //        hourlyItemBinding.imageWeatherIcon.setImageDrawable();


        }
    }
}
