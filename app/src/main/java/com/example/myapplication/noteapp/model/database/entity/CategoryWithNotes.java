package com.example.myapplication.noteapp.model.database.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CategoryWithNotes {
    @Embedded
    private Category category;
    @Relation(
            parentColumn = "name",
            entityColumn = "category"
    )
    private List<Note> notes;

    public CategoryWithNotes(Category category, List<Note> notes) {
        this.category = category;
        this.notes = notes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
