package com.example.foodproj.Presentation.Repository.Room;


import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.foodproj.Domain.Model.Food;
import com.example.foodproj.Presentation.Repository.Room.DAO.FoodDAO;

import java.util.List;

public class FoodRepository {
    private FoodDAO m1name;
    private LiveData<List<Food>> AllFood;

    public FoodRepository(Application application) {
        FoodRoomDatabase db = FoodRoomDatabase.getDatabase(application);
        m1name = db.foodDao();
        AllFood = m1name.getFood();
    }
    public LiveData<List<Food>> getAllFood() {
        return AllFood;
    }
    public void insert(Food name) {
        FoodRoomDatabase.databaseWriteExecutor.execute(() -> {
            m1name.insert(name);
        });
    }
}
