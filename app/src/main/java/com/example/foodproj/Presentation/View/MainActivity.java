package com.example.foodproj.Presentation.View;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodproj.Domain.Model.Food;
import com.example.foodproj.Presentation.ViewModel.FoodViewModel;
import com.example.foodproj.Presentation.ViewModel.NewFoodActivity;
import com.example.foodproj.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static final int NEW_FOOD_ACTIVITY_REQUEST_CODE = 1;

    private FoodViewModel mFoodViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final FoodListAdapter adapter = new FoodListAdapter(new FoodListAdapter.FoodDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFoodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this, NewFoodActivity.class);
            startActivityForResult(intent, NEW_FOOD_ACTIVITY_REQUEST_CODE);
        });
        mFoodViewModel.getAllFood().observe(this, foods -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(foods);
        });
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.READ_CONTACTS},1);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_FOOD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Food name = new Food(data.getStringExtra(NewFoodActivity.EXTRA_REPLY));
            mFoodViewModel.insert(name);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

    public void contactList(View view) {
        Intent intent = new Intent(this,ContactActivity.class);
        startActivity(intent);
    }
    public void converter (View view) {
        Intent intent = new Intent(this,ConverterActivity.class);
        startActivity(intent);
    }

}


