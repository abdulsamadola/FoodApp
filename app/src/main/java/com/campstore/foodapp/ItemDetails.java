package com.campstore.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.campstore.foodapp.controller.FoodItemQtyRecyclerAdapter;
import com.campstore.foodapp.model.FoodItemQty;

import java.util.ArrayList;

import spencerstudios.com.bungeelib.Bungee;

public class ItemDetails extends AppCompatActivity {
private FoodItemQtyRecyclerAdapter mFoodItemQtyRecyclerAdapter;
private ArrayList<FoodItemQty> mFoodItemQties;
private RecyclerView mRecyclerViewQty;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.slideDown(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_item_details);

         recyclerViewHandler();

    }

    private void recyclerViewHandler() {
        mFoodItemQties = new ArrayList<>();

        mFoodItemQties.add(new FoodItemQty("266", "Calories", "Kcal"));
        mFoodItemQties.add(new FoodItemQty("11", "Protein", "g"));
        mFoodItemQties.add(new FoodItemQty("598", "Sodium", "mg"));
        mFoodItemQties.add(new FoodItemQty("17", "Cholestrol", "mg"));
        mFoodItemQties.add(new FoodItemQty("67", "Water", "H20"));
        mFoodItemQties.add(new FoodItemQty("107", "Vitamin", "val"));

        mRecyclerViewQty = findViewById(R.id.itemQtyRecyclerView);

        mRecyclerViewQty.setHasFixedSize(true);
        mRecyclerViewQty.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mFoodItemQtyRecyclerAdapter = new FoodItemQtyRecyclerAdapter(getApplicationContext(), mFoodItemQties);

        mRecyclerViewQty.setAdapter(mFoodItemQtyRecyclerAdapter);
    }

    public void goBack(View view) {
        onBackPressed();
    }
}
