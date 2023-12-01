package com.example.valyutaconvertor.networking;

import android.app.Notification;
import android.content.Context;

import com.chuckerteam.chucker.api.ChuckerCollector;
import com.chuckerteam.chucker.api.ChuckerInterceptor;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiClient {

    public static Retrofit getRetrofit(Context context) {
        ChuckerCollector chuckerCollector = new ChuckerCollector(context);
        ChuckerInterceptor chuckerInterceptor = new ChuckerInterceptor(context);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chuckerInterceptor)
                .build();
        String BASE_URL = "https://v6.exchangerate-api.com/v6/624890b28a46c04204bd1734/";
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
