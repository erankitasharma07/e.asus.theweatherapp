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
import e.asus.theweatherapp.databinding.DailyItemBinding;
import e.asus.theweatherapp.model.ConsolidatedWeather;

public class DailyDataAdapter extends RecyclerView.Adapter<DailyDataAdapter.MyViewHolder> {

    DailyItemBinding dailyItemBinding;
    List<ConsolidatedWeather> consolidatedWeatherList1;
    Context context1;

    public DailyDataAdapter(Context context1, List<ConsolidatedWeather> consolidatedWeatherList1) {
        this.consolidatedWeatherList1 = consolidatedWeatherList1;
        this.context1 = context1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        dailyItemBinding = DataBindingUtil.inflate(inflater, R.layout.daily_item, parent, false);
        return new MyViewHolder(dailyItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(consolidatedWeatherList1.get(position));
    }

    @Override
    public int getItemCount()
    {
        return consolidatedWeatherList1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View view) {
                super(view);

    }
        public void bind(ConsolidatedWeather consolidatedWeather) {
            double roundOff = Math.round( consolidatedWeather.getTheTemp()* 100.0) / 100.0;
            dailyItemBinding.textWeatherTempDaily.setText(String.valueOf(roundOff));
            if (consolidatedWeather.getWeatherStateName().equals("Showers")) {
                dailyItemBinding.imageWeatherIconDaily.setImageDrawable(ContextCompat.getDrawable(context1, R.drawable.showers));
            }
            if (consolidatedWeather.getWeatherStateName().equals("Heavy Cloud")){
                dailyItemBinding.imageWeatherIconDaily.setImageDrawable(ContextCompat.getDrawable(context1, R.drawable.heavy_cloud));
            }
            if (consolidatedWeather.getWeatherStateName().equals("Heavy Rain")){
                dailyItemBinding.imageWeatherIconDaily.setImageDrawable(ContextCompat.getDrawable(context1, R.drawable.heavy_rain));
            }
            if (consolidatedWeather.getWeatherStateName().equals("Light Cloud")){
                dailyItemBinding.imageWeatherIconDaily.setImageDrawable(ContextCompat.getDrawable(context1, R.drawable.light_clouds));
            }

    }
}
}
