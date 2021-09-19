package com.example.foodproj.Presentation.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodproj.R;

public class FoodViewHolder extends RecyclerView.ViewHolder {
    private final TextView foodItemView;


    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);
        foodItemView = itemView.findViewById((R.id.textView));
    }

    public void bind(String text){
        foodItemView.setText(text);
    }

    static FoodViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent,
                        false);
        return new FoodViewHolder(view);
    }
}
