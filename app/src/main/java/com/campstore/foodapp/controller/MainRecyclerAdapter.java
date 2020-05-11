package com.campstore.foodapp.controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.campstore.foodapp.ItemDetails;
import com.campstore.foodapp.R;
import com.campstore.foodapp.model.FoodItem;

import java.util.ArrayList;

import spencerstudios.com.bungeelib.Bungee;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<FoodItem> mFoodItems;
    public MainRecyclerAdapter(Context context, ArrayList<FoodItem> foodItems) {
        this.mContext = context;
        this.mFoodItems = foodItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodItem foodItem = mFoodItems.get(position);
        if(position%2==0) {
            holder.mListBG.setBackgroundResource(R.drawable.list_main_bg);
        }else {
            holder.mListBG.setBackgroundResource(R.drawable.list_main_bg2);
        }
        holder.mListImage.setBackgroundResource(foodItem.getImage());
        holder.mListTitle.setText(foodItem.getTitle());
        holder.mListRating.setText(String.valueOf(foodItem.getRating()));
        holder.mListPrice.setText(String.valueOf(foodItem.getPrice()));
        holder.mListMins.setText(foodItem.getMin());


    }

    @Override
    public int getItemCount() {
        return mFoodItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout mListBG;
     public FrameLayout mListImage;
     public TextView mListTitle;
        public TextView mListMins;
        public TextView mListRating;
        public TextView mListPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mListBG = itemView.findViewById(R.id.list_background);
            mListImage = itemView.findViewById(R.id.list_image);
            mListTitle = itemView.findViewById(R.id.list_title);
            mListMins = itemView.findViewById(R.id.list_mins);
            mListPrice = itemView.findViewById(R.id.list_price);
            mListRating = itemView.findViewById(R.id.list_rating);

            mListBG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  Context ctx = v.getContext();
                  ctx.startActivity(new Intent(ctx, ItemDetails.class));
                    Bungee.slideUp(ctx);
                }
            });
        }
    }

}
