package com.example.foodproj.Presentation.Repository.Room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodproj.Domain.Model.Food;

import java.util.List;

@Dao
public interface FoodDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Food food);
    @Query("DELETE FROM Food")
    void deleteAll();

    @Query("SELECT * FROM Food ORDER BY name ASC")
    LiveData<List<Food>> getFood();
}
