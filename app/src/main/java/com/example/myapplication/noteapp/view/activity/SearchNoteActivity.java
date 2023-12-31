package com.example.myapplication.noteapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;

import com.example.myapplication.noteapp.R;
import com.example.myapplication.noteapp.model.database.entity.Note;
import com.example.myapplication.noteapp.view.fragment.FoundFragment;
import com.example.myapplication.noteapp.view.fragment.NotFoundFragment;
import com.example.myapplication.noteapp.viewmodel.NoteViewModel;

import java.io.Serializable;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SearchNoteActivity extends AppCompatActivity {
    SearchView searchView;
    NoteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_note);
        searchView = findViewById(R.id.searchView);
        viewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        initSearchView();
    }

    private void initSearchView(){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.isEmpty()){
                    printAllNotes();
                }else{
                    checkIsFound(newText);
                }
                return true;
            }
        });
    }

    private void checkIsFound(String query){
        viewModel.getNotesBySubtext(query).observe(this, notes -> {
            if(!notes.isEmpty()){
                initFoundFragment(notes);
            }else{
                initNotFoundFragment();
            }
        });
    }


    private void printAllNotes(){
        viewModel.getAllNotes().observe(this, this::initFoundFragment);
    }

    private void initFoundFragment(List<Note> notes){
        Bundle bundle = new Bundle();
        bundle.putSerializable("Data", (Serializable) notes);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, FoundFragment.class, bundle)
                .setReorderingAllowed(true)
                .commit();
    }

    private void initNotFoundFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, NotFoundFragment.class, null)
                .setReorderingAllowed(true)
                .commit();
    }



}