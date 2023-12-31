package com.example.myapplication.noteapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.noteapp.R;
import com.example.myapplication.noteapp.adapter.CategoryAdapter;
import com.example.myapplication.noteapp.adapter.RecyclerViewInterface;
import com.example.myapplication.noteapp.adapter.SendDataInterface;
import com.example.myapplication.noteapp.model.database.entity.Category;
import com.example.myapplication.noteapp.model.database.entity.Note;
import com.example.myapplication.noteapp.viewmodel.NoteViewModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NoteDetailsActivity extends AppCompatActivity implements RecyclerViewInterface {
    TextView noteTitle, noteText;
    Note note;
    NoteViewModel viewModel;
    RecyclerView categoryList;
    CategoryAdapter categoryAdapter;
    LinearLayoutManager layoutManager;
    String currentCategoryName = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);
        noteTitle = findViewById(R.id.noteTitle);
        noteText = findViewById(R.id.noteText);
        viewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        initData();
    }

    private void initData(){
        note = (Note) getIntent().getSerializableExtra("Note");
        noteTitle.setText(note.getTitle());
        noteText.setText(note.getText());
        System.out.println(note.getText());
        initCategories();
    }

    private void initCategories(){
        viewModel.getAllCategories().observe(this, this::initRecyclerView);
    }

    private void initRecyclerView(List<Category> categories){
        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        categoryAdapter = new CategoryAdapter(categories, this);
        categoryList = findViewById(R.id.categoryList);
        categoryList.setHasFixedSize(true);
        categoryList.setAdapter(categoryAdapter);
        categoryList.setLayoutManager(layoutManager);
    }
    public void updateNote(View view){
        note.setTitle(noteTitle.getText().toString());
        note.setText(noteText.getText().toString());
        if(currentCategoryName != null){
            note.setCategory(currentCategoryName);
        }
        viewModel.updateNote(note);
        goToMainActivity();
    }

    private void goToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void deleteNote(View view){
        viewModel.deleteNote(note);
        goToMainActivity();
    }

    @Override
    public void onButtonClick(String name) {
        currentCategoryName = name;
    }
}