package com.example.myapplication.noteapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.noteapp.model.database.entity.Category;
import com.example.myapplication.noteapp.model.database.entity.CategoryWithNotes;
import com.example.myapplication.noteapp.model.database.entity.Note;
import com.example.myapplication.noteapp.model.repository.NoteRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;


@HiltViewModel
public class NoteViewModel extends ViewModel {
    private NoteRepository repository;

    @Inject
    public NoteViewModel(NoteRepository repository) {
        this.repository = repository;
    }

    public void insertCategory(Category category){
        repository.insertCategory(category);
    }

    public void insertNote(Note note){
        repository.insertNote(note);
    }

    public void updateNote(Note note){
        repository.updateNote(note);
    }

    public void deleteNote(Note note){
        repository.deleteNote(note);
    }

    public LiveData<List<Category>> getAllCategories(){
        return repository.getAllCategories();
    }

    public LiveData<CategoryWithNotes> getNotesByCategory(String nameCategory){return repository.getNotesByCategory(nameCategory);}

    public LiveData<List<Note>> getAllNotes(){
        return repository.getAllNotes();
    }

    public LiveData<List<Note>> getNotesBySubtext(String searchText){return repository.getNotesBySubtext(searchText);}
}
