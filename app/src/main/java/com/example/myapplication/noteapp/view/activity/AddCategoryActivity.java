package com.example.myapplication.noteapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.noteapp.R;
import com.example.myapplication.noteapp.model.database.entity.Category;
import com.example.myapplication.noteapp.viewmodel.NoteViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AddCategoryActivity extends AppCompatActivity {
    NoteViewModel viewModel;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        editText = findViewById(R.id.editText);
        viewModel = new ViewModelProvider(this).get(NoteViewModel.class);
    }

    public void addCategory(View view){
        viewModel.insertCategory(new Category(editText.getText().toString()));
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}