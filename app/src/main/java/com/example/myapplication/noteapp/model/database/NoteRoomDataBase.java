package com.example.myapplication.noteapp.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.noteapp.model.database.entity.Category;
import com.example.myapplication.noteapp.model.database.entity.Note;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Note.class, Category.class}, exportSchema = false, version = 1)
public abstract class NoteRoomDataBase extends RoomDatabase {
    public abstract AppDao appDao();
}
