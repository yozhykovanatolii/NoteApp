package com.example.myapplication.noteapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.noteapp.R;
import com.example.myapplication.noteapp.adapter.CategoryAdapter;
import com.example.myapplication.noteapp.adapter.RecyclerViewInterface;
import com.example.myapplication.noteapp.model.database.entity.Category;
import com.example.myapplication.noteapp.model.database.entity.Note;
import com.example.myapplication.noteapp.viewmodel.NoteViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AddNoteActivity extends AppCompatActivity implements RecyclerViewInterface {
    NoteViewModel viewModel;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    CategoryAdapter adapter;
    String nameCategory = "";

    EditText title, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        viewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        title = findViewById(R.id.editTextText);
        text = findViewById(R.id.editTextText2);
        initData();
    }

    private void initData(){
        viewModel.getAllCategories().observe(this, this::initRecyclerView);
    }

    public void initRecyclerView(List<Category> categories){
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new CategoryAdapter(categories, this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onButtonClick(String name) {
        nameCategory = name;
    }

    public void addNote(View view){
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        viewModel.insertNote(new Note(title.getText().toString(), text.getText().toString(), currentDate, nameCategory));
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}