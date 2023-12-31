package com.example.myapplication.noteapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.noteapp.R;
import com.example.myapplication.noteapp.model.database.entity.Category;
import com.google.android.material.chip.Chip;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private List<Category> categories;
    private RecyclerViewInterface recyclerViewInterface;

    public CategoryAdapter(List<Category> categories, RecyclerViewInterface recyclerViewInterface) {
        this.categories = categories;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list, parent, false);
        return new ViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.chip.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        Chip chip;

        public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            chip = itemView.findViewById(R.id.chip);
            chip.setOnClickListener(view -> recyclerViewInterface.onButtonClick(chip.getText().toString()));
        }
    }
}
