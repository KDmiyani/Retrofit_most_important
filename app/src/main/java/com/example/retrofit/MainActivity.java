package com.example.retrofit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
  pokerecyadepter adepter;
  ArrayList<Pokemon> pokearry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Getdataservice service = retrofitclientinstence.getRetrofitInstance().
                create(Getdataservice.class);

       /* Call<List<Pokemon>> call = service.getpokemons();

        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
               generateData(response.body());
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"code srkho khar topa",Toast.LENGTH_LONG).show();

            }
        });  */

        Call<pokemonpojo> call = service.getPokemonObject();
        call.enqueue(new Callback<pokemonpojo>() {
            @Override
            public void onResponse(Call<pokemonpojo> call, Response<pokemonpojo> response) {
                pokemonpojo pojo = response.body();
                try {
                    pokearry = new ArrayList<>((pojo.getPokemon()));
                    generateData(pokearry);
                }catch (NullPointerException e){

                    System.out.println(e.getMessage());
                }


            }

            @Override
            public void onFailure(Call<pokemonpojo> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"gdshjgkjdsgvhjgds",Toast.LENGTH_LONG).show();

            }
        });

    }

    public void generateData(ArrayList<Pokemon> poklist){

        ArrayList<Pokemon> pokes = (ArrayList<Pokemon>) poklist;
        adepter = new  pokerecyadepter(poklist,getApplicationContext());
        @SuppressLint("WrongConstant")LinearLayoutManager manager =
                new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);

         RecyclerView recyclerView = findViewById(R.id.recyclev);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adepter);
    }
}
