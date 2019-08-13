package com.example.retrofit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
  pokerecyadepter adepter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Getdataservice service = retrofitclientinstence.getRetrofitInstance().
                create(Getdataservice.class);

        Call<List<Pokemon>> call = service.getpokemons();

        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
               generateData(response.body());
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"code srkho khar topa",Toast.LENGTH_LONG).show();

            }
        });



    }

    public void generateData(List<Pokemon> poklist){

        ArrayList<Pokemon> pokes = (ArrayList<Pokemon>) poklist;
        adepter = new  pokerecyadepter(pokes,getApplicationContext());
        @SuppressLint("WrongConstant")LinearLayoutManager manager =
                new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
       // RecyclerView recyclerView = findViewById(R.id.recyclelyout);
         RecyclerView recyclerView = findViewById(R.id.recyclev);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adepter);
    }
}
