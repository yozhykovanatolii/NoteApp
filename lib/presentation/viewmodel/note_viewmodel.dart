import 'package:flutter/material.dart';
import 'package:get_it/get_it.dart';
import 'package:note_app/data/local/note.dart';
import 'package:note_app/data/note_repository.dart';

class NoteViewModel extends ChangeNotifier {
  final NoteRepository _noteRepository = GetIt.instance<NoteRepository>();
  List<Note> _notes = [];

  List<Note> get notes => _notes;

  NoteViewModel() {
    _getAllNotesFromDB();
  }

  Future<void> _getAllNotesFromDB() async {
    _notes = await _noteRepository.getAllNotes();
    notifyListeners();
  }

  void setSearchText(String searchText) async {
    _notes = await _noteRepository.searchNoteBySearchText(searchText);
    notifyListeners();
  }

  void addNote(Note note) async {
    await _noteRepository.insertNote(note);
    await _getAllNotesFromDB();
  }

  void deleteNote(Note note) async {
    await _noteRepository.deleteNote(note);
    await _getAllNotesFromDB();
  }

  void editNote(Note note) async {
    await _noteRepository.editNote(note);
    await _getAllNotesFromDB();
  }

  void setNote(String title, String body, Note? note) {
    if (note == null) {
      addNote(Note(title: title, body: body));
    } else {
      note.title = title;
      note.body = body;
      editNote(note);
    }
  }
}
