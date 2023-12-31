package com.example.myapplication.noteapp.di;

import com.example.myapplication.noteapp.model.database.AppDao;
import com.example.myapplication.noteapp.model.repository.NoteRepository;

import java.util.concurrent.ExecutorService;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;

@Module
@InstallIn(ViewModelComponent.class)
public class RepositoryModule {
    @Provides
    public NoteRepository provideNoteRepository(AppDao appDao, ExecutorService service){
        return new NoteRepository(appDao, service);
    }
}
