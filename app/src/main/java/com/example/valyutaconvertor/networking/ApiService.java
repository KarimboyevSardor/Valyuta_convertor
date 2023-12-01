package com.example.valyutaconvertor.networking;

import com.example.valyutaconvertor.convertor.Convertor;
import com.example.valyutaconvertor.name.Name;
import com.example.valyutaconvertor.valyuta.Valyuta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("latest/{qiymat}")
    Call<Valyuta> getValyut(@Path("qiymat") String qiymat);

    @GET("pair/{from}/{to}/{value}/")
    Call<Convertor> convert(@Path("from") String from, @Path("to") String to, @Path("value") String value);

    @GET("codes/")
    Call<Name> getName();
}

