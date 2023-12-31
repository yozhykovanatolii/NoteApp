package com.example.myapplication.noteapp.model.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.myapplication.noteapp.model.database.entity.Category;
import com.example.myapplication.noteapp.model.database.entity.CategoryWithNotes;
import com.example.myapplication.noteapp.model.database.entity.Note;

import java.util.List;

@Dao
public interface AppDao {
    @Insert
    void insertCategory(Category category);

    @Insert
    void insertNote(Note note);

    @Update
    void updateNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Query("SELECT * FROM category")
    LiveData<List<Category>> getCategories();

    @Query("SELECT * FROM Note")
    LiveData<List<Note>> getAllNotes();

    @Transaction
    @Query("SELECT * FROM Category WHERE name LIKE :nameCategory")
    LiveData<CategoryWithNotes> getNotesByCategory(String nameCategory);

    @Query("SELECT * FROM Note WHERE title LIKE '%' || :searchText || '%' OR text LIKE '%' || :searchText || '%'")
    LiveData<List<Note>> getNotesBySubtext(String searchText);

}
