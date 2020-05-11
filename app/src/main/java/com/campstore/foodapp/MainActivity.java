package com.campstore.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.campstore.foodapp.controller.MainRecyclerAdapter;
import com.campstore.foodapp.model.FoodItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mainRecyclerView;
    private MainRecyclerAdapter mMainRecyclerAdapter;
    private ArrayList<FoodItem> mFoodItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mFoodItems = new ArrayList<>();
        recyclerViewHandler();
    }

    private void recyclerViewHandler() {
        mainRecyclerView = findViewById(R.id.mainRecyclerView);
        mainRecyclerView.setHasFixedSize(true);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false ));

        mFoodItems.add(new FoodItem(R.drawable.american_burger_icon, "$23", "Beef burger", "55" +
                " " +
                "mins",  4.3f));
        mFoodItems.add(new FoodItem(R.drawable.beef_burger_icon, "$120", "American Burger",
                "89" + " mins", 5.0f));
        mFoodItems.add(new FoodItem(R.drawable.american_burger_icon, "$65", "Isreal Burger", "70" +
                " mins",  3.5f));

        mFoodItems.add(new FoodItem(R.drawable.beef_burger_icon, "$5", "Nigerian Burger", "10" +
                " mins",  2.7f));
        mMainRecyclerAdapter = new MainRecyclerAdapter(getApplicationContext(), mFoodItems);

        mainRecyclerView.setAdapter(mMainRecyclerAdapter);

    }
}
