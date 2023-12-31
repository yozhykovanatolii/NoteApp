package com.example.myapplication.noteapp.model.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.myapplication.noteapp.model.database.AppDao;
import com.example.myapplication.noteapp.model.database.NoteRoomDataBase;
import com.example.myapplication.noteapp.model.database.entity.Category;
import com.example.myapplication.noteapp.model.database.entity.CategoryWithNotes;
import com.example.myapplication.noteapp.model.database.entity.Note;

import java.util.List;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

public class NoteRepository {
    private AppDao appDao;
    private ExecutorService service;

    @Inject
    public NoteRepository(AppDao appDao, ExecutorService service){
        this.appDao = appDao;
        this.service = service;
    }

    public void insertCategory(Category category){service.execute(() -> appDao.insertCategory(category));}

    public void insertNote(Note note){
        service.execute(() -> appDao.insertNote(note));
    }

    public void deleteNote(Note note){
        service.execute(() -> appDao.deleteNote(note));
    }

    public void updateNote(Note note){
        service.execute(() -> appDao.updateNote(note));
    }

    public LiveData<CategoryWithNotes> getNotesByCategory(String nameCategory){return appDao.getNotesByCategory(nameCategory);}

    public LiveData<List<Note>> getNotesBySubtext(String searchText){return appDao.getNotesBySubtext(searchText);}

    public LiveData<List<Note>> getAllNotes(){
        return appDao.getAllNotes();
    }

    public LiveData<List<Category>> getAllCategories(){
        return appDao.getCategories();
    }
}
