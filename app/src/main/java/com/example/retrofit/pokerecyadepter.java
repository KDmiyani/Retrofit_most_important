package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class pokerecyadepter extends RecyclerView.Adapter<pokerecyadepter.Viewholder> {

    private ArrayList<Pokemon> pkearry;
    private Context c;
    private View.OnClickListener pokelistner;


    public pokerecyadepter(ArrayList<Pokemon> pkearry, Context c) {
        this.pkearry = pkearry;
        this.c = c;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem,parent,false);
        return  new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        Glide.with(c).asBitmap().load(pkearry.get(position).getImage()).into(holder.poke_img);
      //  Glide.with(context).load(foods.get(position).getImg()).into(holder.img);

        holder.poke_name.setText(pkearry.get(position).getName());
      //  holder.name.setText(foods.get(position).getName());

    }
    public void setOnItemClickListner(View.OnClickListener itemClickListner){
        pokelistner = itemClickListner;
    }

    @Override
    public int getItemCount() {
        return pkearry.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder
    {
ImageView poke_img;
TextView poke_name;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            poke_img = itemView.findViewById(R.id.pke_image);
            poke_name = itemView.findViewById(R.id.poke_name);

            itemView.setTag(this);



            itemView.setOnClickListener(pokelistner);
        }
    }
}
