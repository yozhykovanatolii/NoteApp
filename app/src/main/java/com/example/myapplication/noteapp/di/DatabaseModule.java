package com.example.myapplication.noteapp.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.myapplication.noteapp.model.database.AppDao;
import com.example.myapplication.noteapp.model.database.NoteRoomDataBase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {
    @Singleton
    @Provides
    public synchronized AppDao provideAppDao(Context context){
        return Room.databaseBuilder(context.getApplicationContext(), NoteRoomDataBase.class, "NoteApp")
                .build()
                .appDao();
    }

    @Singleton
    @Provides
    public ExecutorService provideExecutorService(){
        return Executors.newFixedThreadPool(4);
    }

    @Singleton
    @Provides
    public static Context provideContext(Application application){
        return application.getApplicationContext();
    }
}
