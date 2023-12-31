package com.example.myapplication.noteapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.noteapp.R;
import com.example.myapplication.noteapp.adapter.CategoryAdapter;
import com.example.myapplication.noteapp.adapter.NoteAdapter;
import com.example.myapplication.noteapp.adapter.NoteInterface;
import com.example.myapplication.noteapp.adapter.RecyclerViewInterface;
import com.example.myapplication.noteapp.model.database.entity.Category;
import com.example.myapplication.noteapp.model.database.entity.CategoryWithNotes;
import com.example.myapplication.noteapp.model.database.entity.Note;
import com.example.myapplication.noteapp.view.fragment.FoundFragment;
import com.example.myapplication.noteapp.viewmodel.NoteViewModel;

import java.io.Serializable;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    RecyclerView recyclerView;
    NoteViewModel viewModel;
    CategoryAdapter adapter;

    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        initData();
    }

    public void goToAddCategoryActivity(View view){
        Intent intent = new Intent(this, AddCategoryActivity.class);
        startActivity(intent);
    }

    public void goToAddNoteActivity(View view){
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
    }

    public void goToSearchActivity(View view){
        Intent intent = new Intent(this, SearchNoteActivity.class);
        startActivity(intent);
    }

    public void initData(){
        viewModel.getAllCategories().observe(this, this::initRecyclerView);
        viewModel.getAllNotes().observe(this, this::initNoteAdapter);
    }

    public void initRecyclerView(List<Category> categories){
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new CategoryAdapter(categories, this);
        recyclerView = findViewById(R.id.listCategory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onButtonClick(String name) {
        viewModel.getNotesByCategory(name).observe(this, categoryWithNotes -> initNoteAdapter(categoryWithNotes.getNotes()));
    }

    private void initNoteAdapter(List<Note> notes){
        Bundle bundle = new Bundle();
        bundle.putSerializable("Data", (Serializable) notes);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.Container, FoundFragment.class, bundle)
                .setReorderingAllowed(true)
                .commit();
    }

}