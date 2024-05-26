package com.data.wheather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("weather")
    Call<WeatherData> getCurrentWeather(@Query("q") String location, @Query("appid") String apiKey, @Query("units") String units);
}
