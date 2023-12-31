package com.example.myapplication.noteapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.noteapp.R;
import com.example.myapplication.noteapp.model.database.entity.Note;
import com.example.myapplication.noteapp.utils.TextConverter;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.Holder> {
    private List<Note> noteList;
    private NoteInterface noteInterface;
    private TextConverter converter;


    public NoteAdapter(List<Note> noteList, NoteInterface noteInterface) {
        this.noteList = noteList;
        this.noteInterface = noteInterface;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list, parent, false);
        return new Holder(view, noteInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Note note = noteList.get(position);
        converter = new TextConverter();
        holder.titleText.setText(note.getTitle());
        holder.descriptionText.setText(converter.getText(note.getText()));
        holder.dateText.setText(note.getDate());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        TextView titleText, descriptionText, dateText;

        public Holder(@NonNull View itemView, NoteInterface noteInterface) {
            super(itemView);
            titleText = itemView.findViewById(R.id.titleText);
            descriptionText = itemView.findViewById(R.id.descriptionText);
            dateText = itemView.findViewById(R.id.dateText);
            itemView.setOnClickListener(view -> {
                if(noteInterface != null){
                    int position = getAdapterPosition();

                    if(position != RecyclerView.NO_POSITION){
                        noteInterface.onItemClick(position);
                    }
                }
            });
        }
    }
}
