package com.example.patcoffeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PatCoffAdapter extends RecyclerView.Adapter<PatCoffAdapter.ViewHolder>{



    List<String> foodsList = new ArrayList<String>();
    List<String> foodsNames = new ArrayList<String>();
    List<String> drinksList = new ArrayList<String>();
    List<String> drinksNames = new ArrayList<String>();
    List<String> snacksList = new ArrayList<String>();
    List<String> snacksNames = new ArrayList<String>();
    Context mContext;

    public PatCoffAdapter(Context mContext, List<String> foodsList, List<String> foodsNames, List<String> drinksList, List<String> drinksNames,
                          List<String> snacksList, List<String> snacksNames) {
        this.mContext = mContext;
        this.foodsList = foodsList;
        this.foodsNames = foodsNames;
        this.drinksList = drinksList;
        this.drinksNames = drinksNames;
        this.snacksList = snacksList;
        this.snacksNames = snacksNames;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
    ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if(!foodsList.isEmpty()) {
            // Create food view
            Glide.with(mContext)
                    .asBitmap()
                    .load(foodsList.get(position))
                    .centerCrop()
                    .placeholder(R.drawable.kahluadrinks_wide_coffee)
                    .into(holder.dish);

            holder.dishName.setText(foodsNames.get(position));
        }else if(!drinksList.isEmpty()) {

            // Create drink view
            Glide.with(mContext)
                    .asBitmap()
                    .load(drinksList.get(position))
                    .centerCrop()
                    .placeholder(R.drawable.black_coffee_stock)
                    .into(holder.dish);

            holder.dishName.setText(drinksNames.get(position));
        }else if(!snacksList.isEmpty()) {

            //Create snack view
            Glide.with(mContext)
                    .asBitmap()
                    .load(snacksList.get(position))
                    .centerCrop()
                    .placeholder(R.drawable.coffee_stock)
                    .into(holder.dish);

            holder.dishName.setText(snacksNames.get(position));
        }


    }

    @Override
    public int getItemCount() {
        int d = 0;
        if(!foodsList.isEmpty()){
            d = foodsList.size();
        }else if(!drinksList.isEmpty()){
            d = drinksList.size();
        }else if(!snacksList.isEmpty()){
            d = snacksList.size();
        }
        return d;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    CircleImageView dish;
    TextView dishName;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        dish = itemView.findViewById(R.id.imageDish);
        dishName = itemView.findViewById(R.id.imageDishName);

        }
    }
}
