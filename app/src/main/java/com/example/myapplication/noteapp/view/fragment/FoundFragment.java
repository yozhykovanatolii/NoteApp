package com.example.myapplication.noteapp.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.noteapp.R;
import com.example.myapplication.noteapp.adapter.NoteAdapter;
import com.example.myapplication.noteapp.adapter.NoteInterface;
import com.example.myapplication.noteapp.model.database.entity.Note;
import com.example.myapplication.noteapp.view.activity.NoteDetailsActivity;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FoundFragment extends Fragment implements NoteInterface {
    List<Note> notes;
    NoteAdapter adapter;
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            notes = (List<Note>) getArguments().getSerializable("Data");
            adapter = new NoteAdapter(notes, this);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_found, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), NoteDetailsActivity.class);
        intent.putExtra("Note", notes.get(position));
        startActivity(intent);
    }
}