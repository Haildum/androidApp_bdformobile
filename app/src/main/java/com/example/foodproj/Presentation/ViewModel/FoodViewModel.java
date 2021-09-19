package com.example.foodproj.Presentation.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.foodproj.Domain.Model.Food;
import com.example.foodproj.Presentation.Repository.Room.FoodRepository;

import java.util.List;

public class FoodViewModel extends AndroidViewModel {

    private FoodRepository mRepository;

    private final LiveData<List<Food>> AllFood;

    public FoodViewModel(Application application) {
        super(application);
        mRepository = new FoodRepository(application);
        AllFood = mRepository.getAllFood();
    }
    public LiveData<List<Food>> getAllFood(){return AllFood;}

    public void insert(Food name){mRepository.insert(name);}
}
