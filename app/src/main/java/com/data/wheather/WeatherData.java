package com.data.wheather;

import java.util.List;

public class WeatherData {
    private Main main;
    private Wind wind;
    private List<Weather> weather;

    // Getters
    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public class Main {
        private float temp;
        private int humidity;

        public float getTemp() {
            return temp;
        }

        public int getHumidity() {
            return humidity;
        }
    }

    public class Wind {
        private float speed;

        public float getSpeed() {
            return speed;
        }
    }

    public class Weather {
        private String description;

        public String getDescription() {
            return description;
        }
    }
}

