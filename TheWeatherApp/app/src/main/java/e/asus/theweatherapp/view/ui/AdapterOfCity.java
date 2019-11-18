package e.asus.theweatherapp.view.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import e.asus.theweatherapp.R;

public class AdapterOfCity extends RecyclerView.Adapter<AdapterOfCity.MyViewHolder> {
    private List<ListOfCity> cityList;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.name_of_city, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ListOfCity listOfCity = cityList.get(position);
        holder.tv_city.setText(listOfCity.getTv_city());
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public AdapterOfCity(List<ListOfCity> cityList) {

        this.cityList = cityList;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_city;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_city = itemView.findViewById(R.id.tv_city);



        }
    }
}
