package com.data.wheather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private List<WeatherData> weatherList;
    private TextView temperatureTextView;
    private TextView conditionTextView;

    public WeatherAdapter(List<WeatherData> weatherList, TextView temperatureTextView, TextView conditionTextView) {
        this.weatherList = weatherList;
        this.temperatureTextView = temperatureTextView;
        this.conditionTextView = conditionTextView;
    }

    public WeatherAdapter(List<WeatherData> weatherList) {
        this.weatherList = weatherList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherData weatherData = weatherList.get(position);

        holder.textViewTemperature.setText(weatherData.getMain().getTemp() + "°C");
        holder.textViewHumidity.setText(weatherData.getMain().getHumidity() + "%");
        holder.textViewWindSpeed.setText(weatherData.getWind().getSpeed() + " m/s");
        holder.textViewCondition.setText(weatherData.getWeather().get(0).getDescription());

        // Set temperature and condition in MainActivity TextViews
        temperatureTextView.setText(weatherData.getMain().getTemp() + "°");
        conditionTextView.setText(weatherData.getWeather().get(0).getDescription());

    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTemperature, textViewHumidity, textViewWindSpeed, textViewCondition;
        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTemperature = itemView.findViewById(R.id.textViewTemperature);
            textViewHumidity = itemView.findViewById(R.id.textViewHumidity);
            textViewWindSpeed = itemView.findViewById(R.id.textViewWindSpeed);
            textViewCondition = itemView.findViewById(R.id.textViewCondition);
        }
    }
}
