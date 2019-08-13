package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Getdataservice {



    //if multipule end point add here


    @GET("Vy2abloQD")
    Call<List<Pokemon>> getpokemons();

    @GET("E14trR2lD")
    Call<pokemonpojo> getPokemonObject();
}
