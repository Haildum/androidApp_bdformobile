package com.example.foodproj.Presentation.View;

import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.foodproj.Domain.Model.Food;

public class FoodListAdapter extends ListAdapter<Food, FoodViewHolder> {

    public FoodListAdapter(@NonNull DiffUtil.ItemCallback<Food> diffCallback) {
        super(diffCallback);
    }

    protected FoodListAdapter(@NonNull AsyncDifferConfig<Food> config) {
        super(config);
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return FoodViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food current = getItem(position);
        holder.bind(current.getFood());
    }

    static  class FoodDiff extends DiffUtil.ItemCallback<Food>{
        @Override
        public boolean areItemsTheSame(@NonNull Food oldItem,
                                       @NonNull Food newItem){
            return oldItem == newItem;
        }
        @Override
        public boolean areContentsTheSame(@NonNull Food oldItem,
                                          @NonNull Food newItem){
            return  oldItem.getFood().equals(newItem.getFood());
        }
    }
}
